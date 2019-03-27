#!/usr/bin/env bash
javac -classpath  /home/fallou/Documents/Cours/Master1/S2/Informatique_repartie/LESFOURMIS/jadeLib/lib/jade.jar -d ./bin  src/ants/*.java
java -cp /home/fallou/Documents/Cours/Master1/S2/Informatique_repartie/LESFOURMIS/jadeLib/lib/jade.jar:./bin  jade.Boot -agents host:Village.LaunchUI