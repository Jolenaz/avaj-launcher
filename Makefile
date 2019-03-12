
NAME=Main

.PHONY: clean fclean all re

SRCS_DIR = srcs/

SRC_FILES = Coordinates.java\
			Flyable.java\
			Tower.java\
			WeatherTower.java\
			Aircraft.java\
			AircraftFactory.java\
			Baloon.java\
			Helicopter.java\
			JetPlane.java\
			Parser.java\
			WeatherProvider.java\
			ErrorHandler.java\

OBJ_DIR = pack/
OBJ_FILES = $(SRC_FILES:.java=.class)
OBJ = $(addprefix $(OBJ_DIR), $(OBJ_FILES)  )

RED=\033[1;31m
GREEN=\033[1;32m
YEL=\033[1;33m
NC=\033[0m

all: pack $(NAME).class
	@echo "$(YEL) Project Compiled $(NC)"

pack: srcs/*.java
	@echo "$(GREEN) Compile pack $(NC)"
	@javac -d . srcs/*

$(NAME).class: $(NAME).java
	@echo "$(GREEN) Compile $< $(NC)"
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


	