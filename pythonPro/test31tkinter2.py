#!/usr/bin/env python
# -*- coding: utf-8 -*-
#import tkinter#python3.x
#import Tkinter#python2.x
from tkinter import *

print("python GUI thinter")
class ListPage:
	
	def __init__(self):
		top = Tk()
		top.title("list")
		top.geometry("150x100+550+100")
		top.resizable(False,False)
		
		lst = ['yangssem','python','android','linx']

		lstBox = Listbox(top,selectbackground="orange")

		for item in lst:
			lstBox.insert(0,item)
		def onselected(event):
			w = event.widget
			index = int(w.curselection()[0])
			print("onselected",index)
			print("onselected",w.get(index))
		lstBox.bind("<<ListboxSelect>>",onselected)
		
		lstBox.pack()
		mainloop()
		
#ListPage()
		
		
class InsertPage:
	def __init__(self):
		top = Tk()
		top.title("insert")
		top.geometry("250x100+300+100")
		top.resizable(False,False)

		fnameLabel = Label(top,text="fname:")
		lnameLabel = Label(top,text="lname:")
		fnameLabel.grid(row=0)
		lnameLabel.grid(row=1)


		fnameEntry = Entry(top)
		lnameEntry = Entry(top)
		fnameEntry.grid(row=0,column=1)
		lnameEntry.grid(row=1,column=1)

		def onclick():
			print("onclick",fnameEntry.get(),lnameEntry.get())
			ListPage()

		okButton = Button(top,text="OK",command=onclick)
		okButton.grid(row=2,column=1)

		mainloop()

InsertPage()

