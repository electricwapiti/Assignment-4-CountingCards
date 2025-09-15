package org.example.jmh;

import java.util.concurrent.TimeUnit;
import org.example.Shuffle;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)
@Measurement(iterations = 4)
public class SampleBenchmark {
    @Param({"0", "1", "5", "8", "10", "52", "500"})
    public int arraySize;

    public int[] deck;

    @Setup
    public void setUp() {
        deck = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            deck[i] = i + 1;
        }
    }

    @Benchmark
    @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void naiveBenchmark(Blackhole bh) {
        int[] shuffledDeck = Shuffle.naiveShuffler(deck.clone());
        bh.consume(deck);
        bh.consume(shuffledDeck);
    }

    @Benchmark
    @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void secondBenchmark(Blackhole bh) {
        int[] shuffledDeck = Shuffle.secondShuffler(deck.clone());
        bh.consume(deck);
        bh.consume(shuffledDeck);
    }

    @Benchmark
    @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void fisherYatesBenchmark(Blackhole bh) {
        int[] shuffledDeck = Shuffle.fisherYatesShuffler(deck.clone());
        bh.consume(deck);
        bh.consume(shuffledDeck);
    }
}
