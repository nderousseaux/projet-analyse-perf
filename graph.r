library(ggplot2)

d <- read.table("graphs/results", header=TRUE, fill=TRUE)

ext <- ".png" 
chemin <- "graphs/"


        
#p <- ggplot(d, aes(x=size, y=tmp, color=struct)) +
 #   geom_point() +
  #  geom_smooth()+
   # ggtitle("Comparatif global") +
    #xlab("Nombre d'éléments") +
    #ylab("Temps d'exécution")
    #scale_y_log10()
    #ylim(0, max(d$tmp, na.rm = TRUE))
#p + facet_grid(struct ~ operation) 
#ggsave(paste(chemin,"global", ext, sep=""))



p <- ggplot(subset(d, operation == "getFirst"), aes(x=size, y=tmp, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"getFirst\" sur les structures") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"getFirst", ext, sep=""))

p <- ggplot(subset(d, operation == "getRandom"), aes(x=size, y=tmp, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"getRandom\" sur les structures") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"getRandom", ext, sep=""))

p <- ggplot(subset(d, operation == "getLast"), aes(x=size, y=tmp, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"getLast\" sur les structures") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"getLast", ext, sep=""))

p <- ggplot(subset(d, operation == "contains"), aes(x=size, y=tmp, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"contains\" sur les structures") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"contains", ext, sep=""))

p <- ggplot(subset(d, operation == "remove"), aes(x=size, y=tmp, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"remove\" sur les structures") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"remove", ext, sep=""))


    
p <- ggplot(subset(d, operation == "getFirst"), aes(x=size, y=mem, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"getFirst\" sur les structures (mem)") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"getFirst_mem", ext, sep=""))

p <- ggplot(subset(d, operation == "getRandom"), aes(x=size, y=mem, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"getRandom\" sur les structures (mem)") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"getRandom_mem", ext, sep=""))

p <- ggplot(subset(d, operation == "getLast"), aes(x=size, y=mem, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"getLast\" sur les structures (mem)") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"getLast_mem", ext, sep=""))

p <- ggplot(subset(d, operation == "contains"), aes(x=size, y=mem, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"contains\" sur les structures (mem)") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"contains_mem", ext, sep=""))

p <- ggplot(subset(d, operation == "remove"), aes(x=size, y=mem, color=struct)) +
    geom_point() +
    geom_smooth()+
    ggtitle("Test de l'opération \"remove\" sur les structures (mem)") +
    xlab("Nombre d'éléments") +
    ylab("Temps d'exécution") +
    theme(plot.title = element_text(hjust = 0.5))
#p + facet_grid(struct ~ operation) 
ggsave(paste(chemin,"remove_mem", ext, sep=""))