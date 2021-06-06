# LedgerCo

GOTO LedgerCo directory

Run:
mvn clean install -DskipTests -q assembly:single
java -cp target/geektrust.jar com.example.Main.Geektrust <input-path>

Eg:
java -cp target/geektrust.jar com.example.Main.Geektrust "src/main/resources/input.txt"
