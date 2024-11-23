JAVAC = javac
JAVA = java
SRC_DIR = .
OUT_DIR = out
CP = -cp $(OUT_DIR)


MAIN_CLASS = main.Main


SOURCES = $(wildcard main/*.java display/*.java game/*.java Texture/*.java IO/*.java Resource/*.java utils/*.java game/level/*.java)


all: $(OUT_DIR) compile

$(OUT_DIR):
	mkdir -p $(OUT_DIR)

compile:
	$(JAVAC) -d $(OUT_DIR) $(SOURCES)

run: all
	$(JAVA) $(CP) $(MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR)

.PHONY: all compile run clean
