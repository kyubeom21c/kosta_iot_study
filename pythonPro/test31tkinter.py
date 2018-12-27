#!/usr/bin/env python
# -*- coding: utf-8 -*-
#import tkinter#python3.x
#import Tkinter#python2.x
from tkinter import *

print("python GUI thinter")

top = Tk()
lst = ['yangssem','python','android','linx']

lstBox = Listbox(top)
def onselected(event):
		print("onselected",event.widget.curselection()[0])
lstBox.bind("<<ListboxSelect>>",onselected)
for item in lst:
	lstBox.insert(0,item)
lstBox.pack()
top.mainloop()


