



.PHONY: run 



Tree.class: Tree.java
	javac Tree.java


mortree.class: mortree.java
	javac mortree.java


run: Tree.class mortree.class
	java mortree
