reset
set term post color enhanced solid
set output "plot.eps"
set samples 1000
file1 = "resistance.dat"
file2 = "noresistance.dat"

set key
set xlabel "x [m]"
set ylabel "y [m]"

plot file1 using 2:3 with points title "Trajectory with air resistance", \
 file2 using 2:3 with points title "Trajectory with no air resistance", \
 
set term png
set output "plot.png"
replot

set term windows
set out
replot