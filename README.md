# Appliance-Store-Management

Pasi de rulare:
Dezarhivati arhiva intr-un loc cu acces de write pe device-ul dumneavoastra;
1. Instalare IntelliJ IDEA 2022.3.1;
2. Instalare PostgreSQL (+ pgAdmin4);
3. Deschidere IntelliJ IDEA 2022.3.1;
4. Adaugare driver: File -> Project Structure -> Modules ->
-> Dependencies -> Browse -> deschideti folder-ul dezarhivat si selectati postgresql-42.5.1.jar;
5. Instalare jdk 19 (Oracle OpenJDK version 19) din IntelliJ;
6. Din pgAdmin4 (dupa ce va conectati cu user-ul si parola alese la instalarea SGBD-ul PostgreSQL), se da restore la baza de date (backup-ul se afla
in folder-ul dezarhivat anterior);
7. Activati Tool-ul pentru lucrul cu baze de date din IntelliJ (View -> Window Tools -> Database)
8. Apasati pe butonul [+], selectati PostgreSQL si realizati conexiunea cu baza de date introducand numele bazei de date, user-ul si parola PostgreSQL;
9. Mergeti in src/DataBase/DatabaseConnection si modificati user-ul si parola cu cele folosite la pasul anterior;
10. Rulati aplicatia and enjoy!

Manual de instructiuni:
Aveti posibilitatea de a va conecta drept administrator, apasand butonul "Gestionare produse" sau drept client apasand butonul "Comanda produs".
1. Comanda produs
1.1 Completati adresa de livrare a produsului si adaugati-o in lista
1.2 Apasati pe "Completeaza date personale" si completati toate campurile, dupa care adaugati in lista datele.
1.3 Dupa apasarea butonului "Finalizeaza datele comenzii", va trebui sa completati datele comenzii pe care doriti sa o plasati.
1.4 Urmatorul pas este sa alegeti ce produse doriti sa comandati si apoi plasati comanda.

2. Gestionare produse
2.1 Ca administrator al platformei, puteti adauga produse, apoi puteti sa le impartiti pe categorii.

Versiuni software utilizate:
-IntelliJ IDEA 2022.3.1
