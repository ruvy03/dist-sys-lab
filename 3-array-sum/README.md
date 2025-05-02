sudo apt install gcc make

if error: sudo dpkg --configure -a

sudo apt install gcc make

make

or if you dont use make: gcc -fopenmp -Wall -O2 -o array_sum array_sum.c

./array_sum 40 4
First parameter is the number of elements to be sorted
Second parameter is the number of threads

