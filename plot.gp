reset
set term post color enhanced solid
set output "plot.eps"
set samples 1000
file1 = "resistance.dat"
file2 = "noresistance.dat"
file3 = "partialresistance.dat"

set key
set xlabel "x [m]"
set ylabel "y [m]"

plot file1 using 2:3 with points title "Trajectory with air resistance", \
 file2 using 2:3 with points title "Trajectory with no air resistance", \
 file3 using 2:3 with points title "Trajectory with partial air resistance", \
 
set term png
set output "plot.png"
replot

set term windows
set out
replot






reset
set term post color enhanced solid
set output "error.eps"
set samples 1000
file1 = "error_resistance.dat"
file2 = "error_noresistance.dat"
file3 = "error_partialresistance.dat"

set key
set xlabel "t [s]"
set ylabel "error [m]"

plot file1 using 1:2 with lines title "Error in x with air resistance", \
 file2 using 1:2 with lines title "Error in x with no air resistance", \
 file3 using 1:2 with lines title "Error in x with partial air resistance", \
 file1 using 1:3 with lines title "Error in y with air resistance", \
 file2 using 1:3 with lines title "Error in y with no air resistance", \
 file3 using 1:3 with lines title "Error in y with partial air resistance", \
 
set term png
set output "error.png"
replot