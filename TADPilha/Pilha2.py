# Pilha em python kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
class No:
        
    def __init__(self):
        self.__prev = None
        self.__value = None
        self.__next = None 
        
    def setNext(self, valor):
        self.__next = valor
        
    def setValue(self, valor):
        self.__value = valor
        
    def setPrev(self, valor):
        self.__prev = valor
        
    def getNext(self):
        return self.__next
        
    def getValue(self):
        return self.__value
    
    def getPrev(self):
        return self.__prev
            
class Pilha:
    
    def __init__(self):
        self.__head = No()
        self.__tail = No()
        self.__head.setNext(self.__tail)
        self.__tail.setPrev(self.__head)
        self.__size = 0
        
    def isEmpty(self):
        return self.__size == 0
        
    def tamanho(self):
        return self.__size
    
    def topo(self):
        return self.__tail.getPrev().getValue()
        
    def empilhar(self, valor):
        novoNo = No()
        novoNo.setNext(self.__tail)
        novoNo.setValue(valor)
        novoNo.setPrev(self.__tail.getPrev())
        self.__tail.getPrev().setNext(novoNo)
        self.__tail.setPrev(novoNo)
        self.__size += 1
        
    def desempilhar(self):
        to_remove = self.__tail.getPrev().getValue()
        self.__tail.getPrev().getPrev().setNext(self.__tail)
        self.__tail.setPrev(self.__tail.getPrev())
        self.__size -= 1
        return to_remove