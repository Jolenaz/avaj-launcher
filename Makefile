
NAME=Main

.PHONY: clean fclean all re

SRCS_DIR = srcs/

SRC_FILES = Tower.java\
			WeatherTower.java

OBJ_DIR = pack/
OBJ_FILES = $(SRC_FILES:.java=.class)
OBJ = $(addprefix $(OBJ_DIR), $(OBJ_FILES)  )

RED=\033[1;31m
GREEN=\033[1;32m
YEL=\033[1;33m
NC=\033[0m

all: $(OBJ) $(NAME).class
	@echo "$(YEL) Project Compiled $(NC)"

$(OBJ_DIR)%.class: $(SRCS_DIR)%.java
	@echo "$(GREEN) Compile $< $(NC)"
	@javac -d . $<

$(NAME).class: $(NAME).java
	@echo "$(GREEN) Compile $<"
	@javac $(NAME).java
	@echo "$(NC)"

clean:
	@echo "$(RED) clean"
	rm -rf $(OBJ_DIR)
	@echo "$(NC)"

fclean: clean
	@echo "$(RED) fclean"
	rm -rf $(NAME).class
	@echo "$(NC)"

re: fclean all

run: all
	java $(NAME)


	