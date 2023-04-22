//status([6, 9, 3, 8, 2, 3, 1]) = [6, 3, 2, 1, 9, 3, 8]
    /*
     * 6 --> 0 + 4 = 4
     * 9 --> 1 + 6 = 7
     * 3 --> 2 + 2 = 4
     * 8 --> 3 + 5 = 8
     * 2 --> 4 + 1 = 5
     * 3 --> 5 + 2 = 7
     * 1 --> 6 + 0 = 6
     */
    /**
     * dato un array di interi
     * il metodo restituisce un array che contiene gli elementi dell'array passato come parametro
     * ma l'ordine che rispetteranno dipenderà dal valore del loro stato
     * (lo stato dell'elemento è dato dalla somma del suo indice e il numero di elementi minori di esso)
     * l'ordine in cui sono restituiti
     * corrisponde all'ordine crescente dello stato dell'elemento a cui si riferisce
     * 
     * @param nums
     * @return
     */
    public static int[] status(int[] nums){
        //array per il return che conterrà gli elementi di nums nell'ordine giusto
        int[] output = new int[nums.length];
        /*
         * conta serve per indicare quanti elementi hanno un valore inferiore all'elemento preso in esame
         * 
         * stato serve per salvare il valore dello stato dell'elemento
         */
        int conta = 0, stato = 0;
       
        //PROVA CON ARRAYLIST PER ELIMINARE ELEMENTO DOPO AVERLO INSERITO IN OUTPUT
        //ArrayList<Integer> statiArrayList = new ArrayList<>();
        //l'array ha per elementi gli stati degli elementi del parametro del metodo
        int[] stati = new int[nums.length];
        
        //faccio un ciclo per prendere in esame tutti gli elementi di nums 
        for (int i = 0; i < output.length; i++) {   
            /*
             * questo ciclo serve per contare quanti elementi di nums sono hanno un valore minore
             * dell'elemento preso in esame
             */
            for (int j = 0; j < output.length; j++) {
                if(nums[i] > nums[j])
                    //conta tiene in memoria gli elementi che rispettano la condizione --> '> nums'
                    conta++;
            }
            //terminato il ciclo calcolo il valore dello stato preso in esame con il primo for
            stato = i + conta;
            //gli stati vengono inseriti in modo corretto nel vettore, seguendo l'ordine degli elementi corrispondenti in nums
            stati[i] = stato;
            //PROVA CON L'ARRAYLIST
            //statiArrayList.add(stato);
            //azzero il contatore per calcolare lo stato dell'elemento successivo
            conta = 0;

        }
        //PROVA CON L'ARRAYLIST
        //HashMap<Integer, Integer> relazione = new HashMap<>();
        /*
         * istanzio un elemento di tipo HashMap per creare un'associazione
         * tra l'elemento di nums e il suo stato (elemento di stati)
         * chiave elemento di stati
         * valore elemento di nums
         */
        HashMap<Integer, Integer> statiNums = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            //il put serve per associare la chiave al valore
            //PROVA CON L'ARRAYLIST
            //relazione.put(statiArrayList.get(j), nums[j]);
            statiNums.put(stati[j], nums[j]);         
        }
        
        //uso il metodo sort per ordinare in modo crescente gli elementi di stati
        //NON POSSO USARE L'ARRAYLIST PERCHE' NON RIESCO AD ORDINARLO CON IL SORT
        Arrays.sort(stati);

        
        //con il get richiamo il valore associato alla chiave che passo come parametro

        System.out.println("STAMPA DI ELEMENTI DI STATI");
        for (Integer elemento : stati) {
            System.out.print(elemento + " ");
            
        }
        /*
         * uso un arrayList per poter passare gli elementi ad output
         * e rimuovere l'elemento inserito per aggiornare il minore di volta in volta
         */
        ArrayList<Integer> statiArrayList = new ArrayList<>();
        for (Integer elemento : stati) {
            statiArrayList.add(elemento);
            
        }

        System.out.println("\nSTAMPA DI ELEMENTI DI STATI ARRAYLIST");
        for (Integer elemento : statiArrayList) {
            System.out.print(elemento + " ");
            
        }
        /*
         * per ogni elemento dell'arrayList ciclo
         */
        for (int i = 0; i < statiArrayList.size(); i++) {
            //inizializzo minimo (valore che passerò ad output) con il primo elemento dell'arrayList contentente gli stati
            int minimo = statiArrayList.get(i); 
            /*
             * ciclo per trovare il minimo valore dell'arrayList
             */
            for (int j = 0; j < statiArrayList.size(); j++) {
                if(minimo > statiArrayList.get(j)){
                    minimo = statiArrayList.get(j);
                    System.out.println(minimo);
                    statiArrayList.remove(j);

                }

   
            }
            output[i] = statiNums.get(minimo);

            for (Integer elemento : output) {
                System.out.println(elemento);
                
            }
        }

        return output;
    }
