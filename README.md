# ExamenBD

Pasi de rulare:
1. Deschidere IntelliJ Ultimate.
2. Instalare jdk -> 19 (Oracle OpenJDK version 19).
3. Instalare domeniu postgresql impreuna cu IDE-ul pgAdmin4..
4. Instalare driver postgresql-42.5.1.jar din arhiva proiectului.  (File -> Project Structure -> Modules -> 
-> Dependencies -> browse).
5. Restore la baza de date backupbd.sql din arhiva proiectului in pgAdmin 4
6. Se realizeaza conexiunea cu aceasta baza de date cu ajutorul Tool-ului Database din IntelliJ, completand
username-ul si parola din postgres. (development)
7. Modificare user si parola in clasa DatabaseConnection.java setate in postgres. (rulare)
8. Se ruleaza aplicatia, utilizand operatiile disponibile pe tabelele din baza de date.

Versiuni software utilizate:
-IntelliJ IDEA 2022.3.1
