@rem java -jar target/benchmarks.jar -h
java -jar target/benchmarks.jar -jvmArgs "-Dfile.encoding=cp866" -rff "BenchParamMultiTest.result.csv" -rf CSV ".*BenchParamMultiTest"