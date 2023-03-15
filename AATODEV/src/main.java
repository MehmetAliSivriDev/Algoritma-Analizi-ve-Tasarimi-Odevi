
import java.util.Random;

class bruteForceAlgoritmalari{
     public static int bfAlgoritmasiMaxSayiBulma(int[] dizi) {
        int max = dizi[0];
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] > max) {
                max = dizi[i];
            }
        }
        return max;
    }
     
    public static void bfAlgoritmasiSiralama(int[] dizi){
        for (int i = 0; i < dizi.length; i++){
            int min = i;
            for (int j = i + 1; j < dizi.length; j++){
               if (dizi[j] < dizi[min]){
                min = j;
               } 
      }
      int gecici = dizi[i];
      dizi[i] = dizi[min];
      dizi[min] = gecici;
                  
        }
    }
}


public class main {

    public static void main(String[] args) {
        
        System.out.println("1.Sorunun Cevabi:");
        //1. Soru
        soru1.enBuyukSayiyiBulma();
        
        System.out.println("\n\n4.Sorunun Cevabi:\n");
        //4. Soru
        soru4.siralamaKarsilastirilmasi();
    }
    
}

class soru1{
    
    static Random random = new Random();
    
    
    public static void enBuyukSayiyiBulma(){
        
        //Dizi Oluşturma Işlemi
        int[] dizi = new int[10000];
        
        for (int i = 0; i < dizi.length; i++) 
        {
            dizi[i] = random.nextInt();
        }
        
        /*Dizideki En Buyuk Sayiyi Bulabilmek icin en hizli siralama algoritması
        olan quick sort siralama algoritmasini kullandim.
        */
        
        long baslangicZamani = System.currentTimeMillis();
        siralamaIslemi(dizi, 0, dizi.length - 1);
        System.out.println("Quick Sort Algoritmasi Kullanilarak Bulunan Max Sayi:" + dizi[dizi.length - 1]);
        long bitisZamani = System.currentTimeMillis();
        System.out.println("Quick Sort Algoritmasi Gecen Sure: " + (bitisZamani - baslangicZamani));
        
        System.out.println("\n\n\n");
        
        //Brute Force Algoritmasi Kullanilarak Max Sayiyi Bulma
        
        baslangicZamani = System.currentTimeMillis();
        System.out.println("Brute Force Algoritmasi Kullanilarak Bulunan Max Sayi: " + bruteForceAlgoritmalari.bfAlgoritmasiMaxSayiBulma(dizi));
        bitisZamani = System.currentTimeMillis();
        System.out.println("Brute Force Algoritmasi Gecen Sure: " + (bitisZamani - baslangicZamani));
              
       
    }
    
    //Quick Sort Algoritması
    public static int ayirmaIslemi(int dizi[], int enDusukIndex, int enYuksekIndex)
    {
        int pivot = dizi[enYuksekIndex]; 
        int i = (enDusukIndex-1); 
        for (int j=enDusukIndex; j<enYuksekIndex; j++)
        {
           
            if (dizi[j] <= pivot)
            {
                i++;
 
                
                int temp = dizi[i];
                dizi[i] = dizi[j];
                dizi[j] = temp;
            }
        }
 
        
        int gecici = dizi[i+1];
        dizi[i+1] = dizi[enYuksekIndex];
        dizi[enYuksekIndex] = gecici;
 
        return i+1;
    }
    
    public static void siralamaIslemi(int dizi[], int enDusukIndex, int enYuksekIndex)
    {
        if (enDusukIndex < enYuksekIndex)
        {
           
            int pivotIndex = ayirmaIslemi(dizi, enDusukIndex, enYuksekIndex);
 
            siralamaIslemi(dizi, enDusukIndex, pivotIndex-1);
            siralamaIslemi(dizi, pivotIndex+1, enYuksekIndex);
        }
    }   
}


class soru4{
    
    static Random random = new Random();
    
    public static void siralamaKarsilastirilmasi(){
        
        //Dizi Oluşturma Işlemi
        //Iki tane siralama algoritmasini karsilastiracagimiz icin iki ayri dizi olusturduk.
        int[] dizi1 = new int[10000];
        int[] dizi2 = new int[10000];
        
        for (int i = 0; i < dizi1.length; i++) 
        {
            dizi1[i] = random.nextInt();
        }
        
        //En Hizli Siralama Algoritma Olan Quick Sort'u kullandim.
        
        long baslangicZamani = System.currentTimeMillis();
        siralamaIslemi(dizi1, 0, dizi1.length - 1);
        long bitisZamani = System.currentTimeMillis();
        System.out.println("Quick Sort Siralama Algortimasi Gecen Sure: " + (bitisZamani - baslangicZamani));
        
        System.out.println("\n");
        
        //Brute Force Algoritmasi Kullanilarak Siralama Islemi
        
        baslangicZamani = System.currentTimeMillis();
        bruteForceAlgoritmalari.bfAlgoritmasiSiralama(dizi2);
        bitisZamani = System.currentTimeMillis();
        System.out.println("Brute Force Siralama Algoritmasi Gecen Sure: " + (bitisZamani - baslangicZamani));
    }
    
    
     //Quick Sort Algoritması
    public static int ayirmaIslemi(int dizi[], int enDusukIndex, int enYuksekIndex)
    {
        int pivot = dizi[enYuksekIndex]; 
        int i = (enDusukIndex-1); 
        for (int j=enDusukIndex; j<enYuksekIndex; j++)
        {
           
            if (dizi[j] <= pivot)
            {
                i++;
 
                
                int temp = dizi[i];
                dizi[i] = dizi[j];
                dizi[j] = temp;
            }
        }
 
        
        int gecici = dizi[i+1];
        dizi[i+1] = dizi[enYuksekIndex];
        dizi[enYuksekIndex] = gecici;
 
        return i+1;
    }
    
    public static void siralamaIslemi(int dizi[], int enDusukIndex, int enYuksekIndex)
    {
        if (enDusukIndex < enYuksekIndex)
        {
           
            int pivotIndex = ayirmaIslemi(dizi, enDusukIndex, enYuksekIndex);
 
            siralamaIslemi(dizi, enDusukIndex, pivotIndex-1);
            siralamaIslemi(dizi, pivotIndex+1, enYuksekIndex);
        }
    }   
}

        