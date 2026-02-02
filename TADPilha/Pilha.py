# Pilha em python kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk

class Pilha:
    
    def __init__(self):
        self.__pilha = []
        self.__size = 0
        
        
    def isEmpty(self):
        return self.__pilha[0] == None
        
    def tamanho(self):
        return self.__size
    
    def topo(self):
        return self.__pilha[self.__size - 1]
        
    def empilhar(self, valor):
        self.__pilha.append(valor)
        self.__size += 1
        
    def desempilhar(self):
        to_remove = self.__pilha[self.__size - 1]
        self.__size -= 1
        return to_remove