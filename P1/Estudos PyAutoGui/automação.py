import pyautogui as pg
import time
from time import sleep

# Pegar posições do mouse e da tela:
print(pg.position())
print(pg.size())

#Funções do mouse:
pg.press("alt","tab")
time.sleep(3)
pg.click(1136,125)
#Projeto
