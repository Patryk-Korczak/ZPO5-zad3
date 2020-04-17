# ZPO5-zad3

(1 pkt, EGZEKUTORY ETC.) N = 100 osób (osoba = wątek) rozważa pójście do kina na konkretny seans. Wątki te startują jednocześnie i każdy wątek po losowej liczbie sekund (od 1 do 4s, tylko całkowita liczba sekund) namysłu podejmuje decyzję z prawdopodobieństwem „pozytywnym” (tj. wyjścia do kina) p1 = 0,05.  Kino nie wyświetla filmu, jeśli nie zbierze się minimum 5 widzów. W takim przypadku trzeba wyświetlić napis typu: „Przepraszamy, filmu nie będzie.” i program się kończy.  W przeciwnym wypadku wyświetla się film, którego symulowany czas trwa 4s. Ale film jest nudny i dokładnie w połowie seansu każdy z widzów podejmuje decyzję: wyjść 
(z prawdopodobieństwem p2 = 0,3) lub zostać. Jeśli liczba osób, które została nadal wynosi >= 5, to film jest kontynuowany. Jeśli nie, to film zostaje przerwany, a kierownictwo kina wypisuje obraźliwy komunikat (o frajerach i o tym, że pieniędzy za bilety nie oddają...). 
 
Uwaga: napisz klasy Osoba oraz Widz. Wątków-osób będzie 100, wątków-widzów dużo mniej (zwykle około 100 * p1 = 5).  Skorzystaj z egzekutorów.
