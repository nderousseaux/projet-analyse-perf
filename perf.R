#!/bin/R

library(ggplot2)

df <- read.table("perf.dat", header=TRUE)

png("prealable.png")
ggplot(df,aes(x=taille,y=exectime,colour=version)) +
  geom_point() + geom_smooth() +
  ggtitle("Mesures préalables des 4 versions")
dev.off()
