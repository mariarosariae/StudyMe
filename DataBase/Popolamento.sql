Use studyme;

/*AMMINISTRATORE*/
INSERT into amministratore(nomeAmministratore,password,confPassword,email)
	values	('CiroCipo','ciruzzo','ciruzzo','ciro.cipo@live.it'),
			('xChicca','baymax','baymax','xchicca@hotmail.it'),
            ('mRachele','mariarachele','mariarachele','mariaRachele@outlook.it');
            
/*CLIENTE*/
INSERT into cliente(nomeUtente,password,email)
	values	('GiusyA','annunziata','annunziata_giusy@live.it'),
			('FrancescaP','arale','perillo_francesca@hotmail.it'),
            ('AlessiaT','ciaoalessia','testalessia94@livr.it'),
            ('VincentM','partigiano','vincent.millione@virgilio.it'),
			('CladiaB','clacla','b.claudia@gmail.com');
            
 /*CATEGORIA*/
 INSERT  into categoria(nomeCategoria)
	values	('Sviluppo'),
            ('Informatica'),
            ('Produttività'),
            ('Design'),
            ('Musica'),
            ('Fotografia'),
            ('Insegnamento'),
            ('Business');
	
/*SOTTOCATEGORIA*/
INSERT into sottoCategoria(idSottocat,nomeSott)
	values	('svi001','Linguaggio di programmazione'),
			('svi002','Database'),
            ('svi003','Web Development'),
            ('svi004','Mobile Development'),
            ('svi005','Game Development'),
            ('inf001','Sistema Operativo'),
            ('inf002','Reti'),
            ('pro001','Microsoft'),
            ('pro002','Oracle'),
            ('des001','Graphic Design'),
            ('des002','Game Design'),
            ('des003','Architettura Design'),
			('des004','3D & Animazione'),
            ('mus001','Vocal'),
            ('mus002','Strumenti'),
			('mus003','Software musicali'),
            ('mus004','Teoria Musicale'),
            ('fot001','Video Design'),
            ('fot002','Fotografia Digitale'),
            ('fot003','Fotografia Commerciale'),
            ('ins001','Matematica'),
            ('ins002','Lingue'),
            ('ins003','Test di preparazione'),
            ('bus001','Strategia di mercato'),
            ('bus002','Social media marketing');
            
    /*PACCHETTO*/
    INSERT into pacchetto(codicePacchetto,categoria,idSott,prezzo,descrizione,titolo)
	values	('pac001','Sviluppo','svi001',49.90,'C è un linguaggio utile per quasi tutti i programmatori di computer. Alla fine di questo corso, capirai i fondamenti del linguaggio di programmazione C e ti renderai più commerciabile per le posizioni di programmazione entry level','Programmazione C per principianti'),
			('pac002','Sviluppo','svi001',65.00,'C ++ può essere difficile da imparare, ma farlo ha enormi profitti. Se sei interessato ad imparare come usare C ++ per lo sviluppo del gioco, o una più ampia introduzione all\'argomento', 'Iniziare la programmazione in C ++ - Da principiante ad oltre'),
            ('pac003','Sviluppo','svi001',79.99,'Java è uno dei linguaggi di programmazione più popolari. Java offre funzioni di programmazione sia orientate agli oggetti che funzionali','Programmazione Java per principianti '),
			('pac004','Sviluppo','svi001',140.00,'Questo corso è rivolto a principianti inesperti che non hanno mai programmato prima, così come programmatori esistenti che vogliono aumentare le loro opzioni di carriera imparando Python. Il fatto è che Python è uno dei linguaggi di programmazione più popolari al mondo: aziende enormi come Google lo utilizzano in applicazioni mission critical come Ricerca Google. E Python è la scelta di linguaggio numero uno per l\'apprendimento automatico, la scienza dei dati e l\'intelligenza artificiale. Per ottenere quei lavori che pagano molto, hai bisogno di una conoscenza approfondita di Python, ed è quello che otterrai da questo corso.','Impara Python programming'),
			('pac005','Sviluppo','svi002',169.99,'Stabilire le basi più solide possibili nello sviluppo di database imparando a utilizzare MySQL, il database open source più popolare al mondo : scrivere query, creare report a proprio piacimento, creare applicazioni Web, incorporare MySQL come livello di database - rendere i propri sogni di sviluppo una realtà seguendo questo corso e mettendo un segno di spunta accanto al tuo skillset di sviluppo in crescita.','Il corso completo per sviluppatori MySQL'),
			('pac006','Sviluppo','svi002',194.99,'Per prima cosa iniziamo il corso con l\'introduzione di base sui database e comprendiamo cosa sono esattamente i database e perché vengono utilizzati. Quindi apprendiamo come installare gli strumenti necessari che ci permetteranno di creare i nostri database e aggiungere dati al suo interno.Andando avanti, impariamo alcuni operatori SQL, e impariamo anche come questi operatori possono essere utilizzati nelle query SQL che ci permette di formare query più complesse.','Corso SQL per principianti: imparare SQL usando il database MySQL'), 
			('pac007','Sviluppo','svi003',144.95,'HTML e CSS sono le due lingue più importanti da apprendere per un nuovo sviluppatore web. Sono anche i più facili. Se hai sempre desiderato creare pagine web, ma il codice ti ha intimidito, questo corso ti aiuterà a imparare le tue prime due lingue in modo rapido e semplice.','Costruisci siti web da zero con HTML e CSS'),
			('pac008','Sviluppo','svi003',199.99,'Questo corso è una guida passo passo che ti prenderà per mano e ti guiderà attraverso le basi assolute e ti mostrerà tutto ciò che devi imparare per iniziare con JavaScript.','JavaScript per principianti - Impara JavaScript da zero'),
			('pac009','Sviluppo','svi003',89.99,'Non è richiesta alcuna conoscenza dei prerequisiti e non è necessario un sito Web o un account di hosting web esistente. Sarai configurato con un nuovo account di hosting gratuito in modo da poter iniziare a imparare WordPress immediatamente senza dover impegnare ulteriori risorse per un dominio di dot com in anticipo','WordPress per principianti: creare un sito Web passo dopo passo'),
			('pac010','Sviluppo','svi004',171.50,'In questo corso, scoprirai la potenza dello sviluppo di app per Android e otterrai le competenze per aumentare notevolmente le tue prospettive di carriera come sviluppatore di software. Avrai anche un vantaggio sugli altri sviluppatori che utilizzano strumenti obsoleti e versioni precedenti di Android.','Android Java Masterclass - Diventa uno sviluppatore di app'),
			('pac011','Sviluppo','svi004',145.00,'Benvenuto nel corso più completo del mondo per lo sviluppo di iOS.Questo corso è progettato come un bootcamp di codifica personale per offrirti la maggior quantità di contenuti e aiutare con il minor costo possibile.','iOS 10 e Swift 3: dal principiante al professionista'),
			('pac012','Sviluppo','svi005',189.99,'Questo è il corso più completo su Unity 3d su Internet. Siamo avidi sviluppatori di giochi e siamo stanchi di tutta la spazzatura là fuori - insegnando agli studenti come realizzare cubi 3D senza sviluppo del mondo reale.','Sviluppo giochi Unity Costruisci giochi 2D e 3D'),
			('pac013','Informatica','inf001','39.99','Il nostro corso Shell Scripting è stato specificamente progettato per insegnarti come utilizzare BASH per radere ore dalla tua pratica di codifica. Scopri come scrivere script di shell, imparare come funzionano la cronologia dei comandi, il comando echo e anche le variabili, e come automatizzare comandi semplici e complessi.','Programmazione della shell Linux'),
			('pac014','Informatica','inf002',119.90,'Dopo questo corso, sarete in grado di scoprire le vulnerabilità della sicurezza su un\'intera rete, utilizzando tecniche di hacking della rete e scansione delle vulnerabilità .','Il corso completo sulla sicurezza informatica'),
			('pac015','Informatica','inf002',99.99,'Questo corso sulla rete informatica insegnerà tutti i fondamenti relativi alla rete di computer; Dalla spiegazione delle basi delle reti informatiche, dei modelli di comunicazione e delle conferenze dettagliate sui livelli di una rete. Questo corso ha diagrammi illustrativi e animati per aiutarti a capire i concetti in un modo più semplice.','Computer Network: Fondamenti di rete'),
			('pac016','Produttività','pro001',40.00,'Questo corso di formazione completo di Microsoft Word ti insegnerà come progettare e personalizzare i documenti professionali.','Microsoft Word completa'),
			('pac017','Produttività','pro001',70.00,'In questo imparerai come padroneggiare PowerPoint con semplici istruzioni passo passo. Questo corso comprende strumenti PowerPoint di base e avanzati. Con questi video tutorial facili da seguire, chiunque può imparare a creare presentazioni professionali. ','Corso di PowerPoint'),
			('pac018','Produttività','pro001',65.00,'Al termine di questo corso avrai padroneggiato gli strumenti di Excel più diffusi e ne uscirai con fiducia per completare qualsiasi attività di Excel con efficienza e grazia.','Microsoft Excel - Excel da principiante ad avanzato'),
			('pac019','Produttività','pro001',100.00,'Questo corso è progettato per farti sentire comodo e sicuro utilizzando Access. È progettato per iniziare con le competenze necessarie per organizzare i dati nelle tabelle, estrarre i dati utilizzando le query e creare report puliti e professionali per impressionare il tuo capo.','Completa la padronanza di Microsoft Access'),
			('pac020','Produttività','pro002',55.00,'Un corso facile da seguire progettato per insegnarti i principi fondamentali del lavoro con Oracle Database Technology','Apprendimento di Oracle 12c: un video di formazione Oracle'),
			('pac021','Produttività','pro002',180.00,'Impara a diventare un amministratore di database Oracle (DBA) in 6 settimane e ottenere un lavoro ben pagato come un DBA Junior.','Oracle DBA 11g / 12c - Amministrazione database per DBA junior'),
			('pac022','Design','des001',120.5,'Master Photoshop CC 2019 senza alcuna conoscenza precedente con questo corso facile da seguire','Corso di Photoshop'),
			('pac023','Design','des001',150.5,'Scopri il design grafico di Adobe Illustrator CC, il design del logo e altro ancora con questo corso approfondito, pratico e facile da seguire!','Adobe Illustrator CC'),
			('pac024','Design','des001',179.99,'Creare newsletter aziendali, brochure, relazioni annuali. Impara tipografia, teoria dei colori e abilità di progettazione grafica in InDesign','Adobe InDesign CC '),
			('pac026','Design','des002','200.00','Una guida completa che ti accompagna in ogni fase della costruzione di un gioco SHMUP professionale e raffinato utilizzando UE4.','Unreal Engine 4 - Impara a creare un prototipo di gioco in UE4'),
			('pac027','Design','des003',60.00,'Un corso completo per l\'apprendimento di AutoCAD da zero a livello professionale','Il corso completo di AutoCAD'),
			('pac028','Design','des004',194.99,'Usa Blender per creare bellissimi modelli 3D per videogiochi, stampa 3D, design di case, ecc. Nessuna conoscenza richiesta.','Completa Blender Creator: impara la modellazione 3D'),
			('pac029','Design','des004',140.00,'Guida AZ all\'apprendimento di animazioni 3D e modellazione con Blender per impostare l\'utente sulla creazione di fantastiche opere d\'arte 3D','Scopri l\'animazione 3D: la guida definitiva di Blender'),
			('pac030','Musica','mus001',99.99,'Il sistema di canto passo dopo passo ha dimostrato di sviluppare grande tecnica e maestria vocale, i risultati sono immediati!','Corso di canto'),
			('pac031','Musica','mus002',99.99,'Corso di chitarra all-in-one con un comprovato sistema di apprendimento passo-passo.','Corso di chitarra'),
			('pac032','Musica','mus002',75.50,'Dopo aver completato questo corso, sarai in grado di riprodurre qualsiasi tipo di musica in qualsiasi tipo di stile con qualsiasi tipo di firma chiave.Il materiale in questo corso ti fornirà una guida passo passo per apprendere l\'utilizzo del pianoforte','Corso di pianoforte'),
			('pac033','Musica','mus002',139.99,'Corso di violino per principianti - Start Violin from Scratch - Il corso di violino per principianti più approfondito disponibile online.','Corso per violino'),
			('pac034','Musica','mus003',180.00,'Unisciti alla produzione musicale di successo + Gli studenti di Logic Pro X nella creazione, registrazione, mixaggio di musica e mastering in Logic Pro X','Produzione musicale in Logic Pro X - Il corso completo!'),
			('pac035','Musica','mus003',50.00,'Master Avid Pro Tools 11. Scopri i segreti di produzione audio utilizzati dai professionisti. Un tutorial di Pro Tools facile da seguire.','Master Pro Tools 11 - Un corso Pro Tools definitivo'),
			('pac036','Musica','mus004',70.00,'Un approccio approfondito e diretto per comprendere la musica.','Teoria musicale'),
			('pac037','Fotografia','fot001',140.00,'In questo corso completo gli studenti impareranno come modificare i loro video utilizzando Final Cut Pro X da principiante a intermedio','Il corso Final Cut Pro X completo per principianti fino a intermedio'),
			('pac038','Fotografia','fot001',170.00,'Se stai cercando un\'applicazione di editing video che ti consenta di modificare i video come preferisci, Adobe Premiere Pro è la migliore risposta. Premiere Pro è utilizzato da professionisti di tutto il mondo per ogni tipo di produzione da video aziendali e di marketing, video musicali a documentari, lungometraggi. Questo corso completo è il modo migliore per entrare subito e iniziare a modificarlo.','Adobe Premiere Pro CS6: il corso di editing video completo'),
			('pac039','Fotografia','fot002',49.99,'Scopri come utilizzare la videocamera in modo intuitivo. Impara facendo piuttosto che memorizzando.','Fotografia principiante'),
			('pac040','Fotografia','fot002',99.99,'Scatti meravigliose foto notturne che impressionano la tua famiglia e i tuoi amici con questo corso completo di fotografia notturna!','Fotografia notturna: puoi scattare foto mozzafiato di notte' ),
			('pac041','Fotografia','fot003',49.99,'Con la fotografia di base , puoi imparare rapidamente a scattare meravigliose foto di cibo anche se non hai mai preso una macchina fotografica e non hai mai disegnato un piatto di cibo!','Fotografia di base dell\'alimento'),
			('pac042','Fotografia','fot003',189.99,'Impara esattamente come diventare un fotografo di matrimoni, avviare un\'attività fotografica per conto tuo e scattare foto di nozze migliori.','Fotografia di matrimonio: guida completa alla fotografia di matrimonio'),
			('pac043','Insegnamento','ins001',30.00,'Primo corso in Algebra (inizio algebra).','Algebra I (Algebra iniziale)'),
			('pac044','Insegnamento','ins001',79.99,'Più di 60 domande risolte per aiutarvi ad entrare nel flusso di problemi statistici di cracking (Binomiale, Distribuzione Normale ecc.)','Statistiche: variabili casuali e distribuzioni di probabilità'),
			('pac045','Insegnamento','ins001',98.99,'Master Discrete Math, la spina dorsale di Matematica e Informatica','Matematica discreta'),
			('pac046','Insegnamento','ins002',199.99,'Impara l\'inglese per principianti (A1-> A2 +) ','Corso di inglese completo: Impara la lingua inglese'),
			('pac047','Insegnamento','ins002',199.99,'Corso di spagnolo per principianti - Impara la lingua spagnola ','Corso di spagnolo completo: Impara la lingua spagnola | principianti'),
			('pac048','Business','bus001', 164.99,'Scopri come utilizzare l\'analisi aziendale per consigliare la soluzione migliore e cambiare strategia per raggiungere gli obiettivi della tua organizzazione ' ,'Analisi Aziendale : condurre un\'analisi strategica'),
			('pac049','Business','bus001',149.99,'Strategia aziendale: capire cosa serve per avere successo negli affari','Business Fundamentals: strategia aziendale'),
			('pac050','Business','bus002',174.99,'La guida AZ per far crescere il tuo seguito su Instagram, massimizzare il tuo coinvolgimento e aumentare lead e vendite.','Il corso completo di marketing su Instagram'),
			('pac051','Business','bus002',199.99,'Domina la pubblicità su Facebook e fai crescere qualsiasi attività commerciale: strategia di marketing su Facebook, retargeting degli annunci, remarketing e altro ancora!','Il corso completo di annunci di Facebook');

/*LEZIONI*/
INSERT INTO lezioni(url,titolo,durata,codiceP)
	values	('https://www.youtube.com/watch?v=4ynmgioiuJU&list=PLkX4wWMyzbftBUmT3Lvxf46OwYmDzRWwQ','Lezione 1-introduzione alla programmazione in C','7:11','pac001'),
			('https://www.youtube.com/watch?v=cQBIHAEcjxw&list=PLkX4wWMyzbftBUmT3Lvxf46OwYmDzRWwQ&index=3','Lezione 2-Variabili cosa sono e come si usano','34:19','pac001'),
            ('https://www.youtube.com/watch?v=AehEtQ3XVV4&list=PL0qAPtx8YtJfZpJD7uFxAXglkiHSEhktG','Lezione 1- Presentazione del corso C++','8:58','pac002'),
            ('https://www.youtube.com/watch?v=sTT9veneQIU&list=PL0qAPtx8YtJfZpJD7uFxAXglkiHSEhktG&index=3','Lezione 2 - configuriamo gli ambienti di lavoro ','12:12','pac002'),
            ('https://www.youtube.com/watch?v=7PGPLqFpDMc&list=PL0qAPtx8YtJe2dpE7di4aPJwrQuRD6IDD','Lezione 1 - Introduzione al corso Java','9:17','pac003'),
            ('https://www.youtube.com/watch?v=2tILwFBOPj0&list=PL0qAPtx8YtJe2dpE7di4aPJwrQuRD6IDD&index=2','Lezione 2 - Una marea di sigle. Diamo il giusto significato a ciascuna ed iniziamo ad installare quello che ci serve.','10:22','pac003'),
            ('https://www.youtube.com/watch?v=mXWXUzgok_I&list=PLHUQL6-_n9Zes1VLMgJbLa8IIOHT9x4Nu','Lezione 1 - Introduzione a  Python e istallazione su windows','4:09','pac004'),
            ('https://www.youtube.com/watch?v=7HS_XYUYsm0&list=PLHUQL6-_n9Zes1VLMgJbLa8IIOHT9x4Nu&index=2','Lezione 2 - Come Usare IDLE e Fare Operazioni Numeriche','6:22','pac004'),
            ('https://www.youtube.com/watch?v=aM5aDsipBzs&list=PLBEBB93C692220379','Lezione 1 - introduzione a MySql(part1)','6:32','pac005'),
            ('https://www.youtube.com/watch?v=wAjteSIeT9Y&list=PLBEBB93C692220379&index=2','Lezione 2 - Imparate mysql ','4:16','pac005'),
            ('https://www.youtube.com/watch?v=jM55Fb9YTfE&list=PLE555DB6188C967AC','Lezione 1 - Introduzione linguaggio SQL','16:12','pac006'),
            ('https://www.youtube.com/watch?v=lwol3ceznag&list=PLE555DB6188C967AC&index=2','Lezione 2 - Creare una data base con SQL Server e Visual Studio','37:29','pac006');