
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author arrizky
 */
class BankData {

    String indonesia;
    String english;

    public BankData(String indo, String eng) {
        indonesia = indo;
        english = eng;
    }
}

class LinkedListNode {

    LinkedListNode next;
    LinkedListNode prev;
    BankData data;

    LinkedListNode(BankData new_data) {
        this.data = new_data;
        this.next = null;
        this.prev = null;
    }

    void set_prev(LinkedListNode other) {
        this.prev = other;
        if (other != null) {
            other.next = this;
        }
    }

    void set_next(LinkedListNode other) {
        this.next = other;
        if (other != null) {
            other.prev = this;
        }
    }
}

class LinkedList {

    LinkedListNode top;

    LinkedList() {
        this.top = null;
    }

    void push(LinkedListNode newNode) {
        if (this.top == null) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top.prev = newNode;
            this.top = newNode;
        }
    }

    LinkedListNode pop() {
        LinkedListNode taken;
        if (this.top == null) {
            taken = null;
        } else if (this.top.next == null) {
            taken = this.top;
            this.top = null;
        } else {
            taken = this.top;
            top = taken.next;
            taken.next = null;
            top.prev = null;
        }
        return taken;
    }
}

public class Responsi1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hashtable<Integer, BankData> data = new Hashtable<Integer, BankData>();

        data.put(0, new BankData("api", "fire"));
        data.put(1, new BankData("air", "water"));
        data.put(2, new BankData("tanah", "land"));
        data.put(3, new BankData("udara", "air"));
        data.put(4, new BankData("tikus", "mouse"));
        data.put(5, new BankData("cinta", "love"));
        data.put(6, new BankData("contoh", "example"));
        data.put(7, new BankData("satu", "one"));
        data.put(8, new BankData("hitam", "black"));
        data.put(9, new BankData("hujan", "rain"));
        data.put(10, new BankData("desa", "village"));
        data.put(11, new BankData("bolpoin", "pen"));
        data.put(12, new BankData("penghapus", "eraser"));
        data.put(13, new BankData("kunci", "key"));
        data.put(14, new BankData("foto", "photo"));
        data.put(15, new BankData("papan", "board"));
        data.put(16, new BankData("buku", "book"));
        data.put(17, new BankData("pantai", "beach"));
        data.put(18, new BankData("wanita", "woman"));
        data.put(19, new BankData("kata", "word"));
        data.put(20, new BankData("kucing", "cat"));
        data.put(21, new BankData("anjing", "dog"));
        data.put(22, new BankData("palu", "hammer"));
        data.put(23, new BankData("kursi", "chair"));
        data.put(24, new BankData("meja", "table"));

        LinkedList soal = new LinkedList();
        boolean ulang = true;
        Scanner angka = new Scanner(System.in);
        Scanner kata = new Scanner(System.in);
        int nilai = 0, benar, salah;
        LinkedListNode soalAktif;

        int pilih;
        do {
            System.out.println("--------------------");
            System.out.println("Permainan Tebak Arti");
            System.out.println("--------------------");
            System.out.println("Pilih menu:");
            System.out.println("1. Mulai");
            System.out.println("2. Lihat Score");
            System.out.println("3. Keluar");
            System.out.print("Pilihan : ");
            pilih = angka.nextInt();
            switch (pilih) {
                case 1:
                    benar = 0;
                    salah = 0;

                    for (int i = 0; i <= 4; i++) {
                        int acak = ThreadLocalRandom.current().nextInt(0, 25);
                        soal.push(new LinkedListNode(data.get(acak)));
                    }

                    int j = 1;
                    while (soal.top != null) {
                        soalAktif = soal.pop();
                        System.out.print("Soal ke - " + j + " : Arti dari " + soalAktif.data.indonesia + " adalah ");
                        String jawaban = kata.next();
                        if (jawaban.equalsIgnoreCase(soalAktif.data.english)) {
                            System.out.println("Jawaban Anda benar.");
                            benar += 1;
                            nilai += 20;
                        } else {
                            System.out.println("Jawaban Anda salah.");
                            salah += 1;
                            nilai -= 10;
                        }
                        j += 1;
                    }

                    System.out.println("Nilai akhir : " + nilai);
                    System.out.println("Jawaban benar : " + benar);
                    System.out.println("Jawaban salah : " + salah);
                    break;
                case 2:
                    System.out.println("Nilai Anda adalah : " + nilai);
                    break;
                case 3:
                    System.out.println("Program selesai.");
                    ulang = false;
                    break;
                default:
                    System.out.println("Pilihan salah. Masukan ulang.");
                    System.out.println();
                    break;
            }
        } while (ulang);

    }

}
