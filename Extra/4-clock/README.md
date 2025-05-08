javac *.java
rmiregistry &
            & makes it run in the background

java MasterNode 500
                parameter is the time for the master clock

new terminal

java SlaveNode s1 2000
                name and time

java SlaveNode s2 6000
