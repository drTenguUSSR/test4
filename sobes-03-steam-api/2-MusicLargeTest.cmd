@rem call 0-make-jar.cmd
@rem java -jar benchmarks.jar -lrf
@rem  -lrf	List machine-readable result formats, and exit.
@rem  -lprof	List profilers, and exit.
del MusicLargeTest.result.json
del MusicLargeTest.result.log
java -jar target/benchmarks.jar -jvmArgs "-Dfile.encoding=UTF-8" -rff "MusicLargeTest.result.json" -rf JSON -o "MusicLargeTest.result.log" ".*MusicLargeTest"