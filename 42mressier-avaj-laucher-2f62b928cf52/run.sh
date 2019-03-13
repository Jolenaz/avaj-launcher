# just a simple compiler for java project

## colors ##
typeset -r RED="\033[31m"
typeset -r GREEN="\033[32m"
typeset -r CLEAR="\033[0m"

## PROJECT ##
typeset -r SOURCES=$(find . -name '*.java')
typeset -r RUN="simulator.Simulator"

clean()
{
	typeset CLASSES_FILES=$(find . -name '*.class')

	echo "Clean:"
	echo "${CLASSES_FILES}";
	rm -rf ${CLASSES_FILES}
}

compile()
{
	typeset -r COMMAND="javac -d . ${SOURCES}"
	echo -e "[${GREEN}COMPILATION${CLEAR}] : ${COMMAND}";

	${COMMAND}; typeset -i EXIT_STATUS=$?;

	echo "Compilation end"
	(( EXIT_STATUS == 0 )) && return 0
	return 1
}

[[ $1 == "clean" ]] && { clean; exit; }

typeset -r ARGUMENTS=$*

compile
typeset -i EXIT_STATUS=$?
(( EXIT_STATUS != 0 )) && { echo -e "${RED}Error during compilation :(${CLEAR}"; exit 1; }

typeset -r COMMAND="java ${RUN}"
echo "Run with : ${COMMAND} <file>"

for ARG in ${ARGUMENTS}
do
	typeset CMD="${COMMAND} ${ARG}"
	echo -e "[${GREEN}RUN${CLEAR}] : ${CMD}"; ${CMD};
done
