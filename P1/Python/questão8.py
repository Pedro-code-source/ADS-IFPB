class Kangaroo:
    def __init__(self):
        self.pouch_contents = []
        
    def put_in_pouch(self,nome):
        self.pouch_contents.append(nome,5)
    
           
         
         
canguru = Kangaroo()
canguru.put_in_pouch(5)
print(canguru.pouch_contents)         