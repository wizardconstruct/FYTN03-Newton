reset
set term png
set output "plot.png"
file = "out.dat"
set termoption dash
set linetype 2 dt 2

plot file using 1:2 every 1000 with lines, \
