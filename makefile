# Makefile for Data Structures Binary Search Tree Assignments

LIB = lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc
JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR):$(JUNIT)

vpath %.java $(SRCDIR):$(TESTDIR)
vpath %.class $(BINDIR)

# define general build rule for java sources
.SUFFIXES:  .java  .class
	-d $(BINDIR)

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

#default rule - will be invoked by make

all: Node.class Tree.class SearchIt.class SearchItLinear.class PrintIt.class TreeNodeTest.class TestSuite.class TestRunner.class

default: -d $(BINDIR) $(ALL)

# Rules for generating documentation
doc:
	javadoc -d $(DOCDIR) -cp $(BINDIR):$(JUNIT) $(SRCDIR)/*.java $(TESTDIR)/*.java

# Rules for unit testing
test_classes: all

test: test_classes
	java -ea -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

clean:
	@rm -f  $(BINDIR)/*.class $(SRCDIR)/*.class
	@rm -f jacoco.exec *.xml *.csv
	@rm -Rf coveragereport
	@rm -Rf doc

printit:
	java -cp $(BINDIR) PrintIt

searchit:
	java -cp $(BINDIR) SearchIt

searchitlinear:
	java -cp $(BINDIR) SearchItLinear
