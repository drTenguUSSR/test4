@rem call 0-make-jar.cmd
@rem java -jar benchmarks.jar -lrf
@rem  -lrf	List machine-readable result formats, and exit.
@rem  -lprof	List profilers, and exit.
java -jar target/benchmarks.jar -o x-musicA4M4SortTest-hr.log -jvmArgs "-Dfile.encoding=UTF-8" ".*MusicA4M4SortTest"
