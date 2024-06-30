@rem call 0-make-jar.cmd

java -jar target/benchmarks.jar -jvmArgs "-Dfile.encoding=cp866" ".*MusicA4M4SortWithPrintTest" >5-MusicA4M4SortWithPrintTest.log
