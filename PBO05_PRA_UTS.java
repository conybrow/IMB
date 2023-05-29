import java.security.interfaces.ECKey;
import java.util.Date;
import java.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

/*  Nama      tanggalkerja       JuridariLomba
 * Aisyah       17/04/20            UIUX
 * Jessica      18/04/20            DATPROS
 * Mclaren      18/04/20            UIUX
 * Zhu Sha      19/04/20            ALGO
 * Aisyah       19/04/20            UIUX
 * Majid        19/04/20            DATPROS
 * Kwan Tae     20/04/20            DATPROS
 * Zhu Sha      20/04/20            ALGO
 * Majid        21/04/20            ALGO
 * 
 * 
 * lomba diselenggarakan pada tanggall 17/04/2020 hingga
 * 21/04/2020
 * 
 * -Tanggal-------------------Acara---------------------Juri
 * 17/04/20 :   Lomba UIUX dengan max 50 tim
 * 18/04/20 :   Lomba Data Processing max 50 tim
 *              Semi Final UIUX
 * 19/04/20 :   Lomba Algoritma dengan max 50 tim
 *              Final UIUX
 *              Semi Final Data Processing
 * 20/04/20 :   Final Final Data Processing
 *              Semi Final ALgoritma
 * 21/04/20 :   Final Algoritma
 */
public class PBO05_PRA_UTS {
    ArrayList<lomba> alllomba = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    SimpleDateFormat parsedate = new SimpleDateFormat("dd/MM/yyyy");
    String idforuiux;
    String idforalgo;
    String idfordatpros;
    String idlomba;
    public Date FORVOID;
    public Date starttgl;
    public Date endtgl;
    public String tglkerja;
    public String Idjuri;
    public String namajuri;
    public int size;
    int urutuiux;
    int urutdatpros;
    int urutalgoritma;
    int nilaiketepatanhasil;
    int nilaiwaktueksekusi;
    int nilaieksekusi;
    int nilaipemanfaatanresource;
    String idurut;
    ArrayList<peserta> aper = new ArrayList<>();
    ArrayList<juri> ajuri = new ArrayList<>();

    public static void main(String[] avfi) {
        PBO05_PRA_UTS main = new PBO05_PRA_UTS();

        main.menu();
    }

    public void menu() {
        int status;
        do {
            System.out.println("\\nt-------------------------------------------------------");
            System.out.println("\n\tLomba ini diselenggarakan pada 17 April 2020");
            System.out.println("\tdan berakhir pada 21 April 2020");
            String startlomba = "170420";
            String endlomba = "210420";
            starttgl = parsetodate(startlomba);// tanggalstart
            endtgl = parsetodate(endlomba);// tanggalend
            idlomba = "AUD20"; // idlomba
            System.out.println("\t Status  : ");
            System.out.println("\n\t1. Peserta ");
            System.out.println("\t2. Juri ");
            System.out.println("\t3. keluar ");
            System.out.print("\n\tInput Number : ");
            status = input.nextInt();

            if (status == 1) {
                System.out.println("\t---------------------------------------------------");
                System.out.println("\n\t Ruang peserta  : ");
                System.out.println("size Alllomba : " + alllomba.size());
                System.out.println("Size participants : " + getsizeparticipants());

                System.out.println("\n\t1. Buat tim ");
                System.out.println("\t2. lihat nilai ");
                System.out.println("\t3. Kembali ");
                System.out.print("\n\tInput number : ");
                int fill2 = input.nextInt();
                if (fill2 == 1) {
                    maketim();
                } else if (fill2 == 2) {
                    System.out.println("\tId Tim\t\tNama Tim\tNilai rata-rata");
                    for (int i = 0; i < alllomba.size(); i++) {
                        alllomba.get(i).viewnilai();
                    }
                } else {
                    System.out.println("Inputan salah, back to menu");
                }
            } else if (status == 2) {
                System.out.print("\n\tKode juri : ");
                int tes = input.nextInt();
                if (tes == 1429) {
                    System.out.println("\n\t Ruang Juri  : ");
                    System.out.println("\t1. lihat Data tim ");
                    System.out.println("\t2. input nilai ");
                    System.out.println("\t3. jadwal juri ");
                    System.out.print("\n\tInput number : ");
                    int inputjuri = input.nextInt();
                    if (inputjuri == 1) {

                    } else if (inputjuri == 2) {
                        cekandshow();
                    } else if (inputjuri == 3) {
                        Jadwaljuri();
                    } else {
                        System.out.println("\tInputan salah, back to menu");
                    }
                } else {
                    System.out.println("\tMaaf anda tidak lolos tes");
                }

            } else {
                System.out.println("\t inputan salah");
            }
        } while (status != 3);
    }

    public int getsizeparticipants() {
        for (int i = 0; i < alllomba.size(); i++) {
            int a = alllomba.get(i).getsizeparticipants();
            size = +a;
        }
        return size;
    }

    public void cekandshow() {
        System.out.println("\tNama tim/Idtim/namapeserta/idpeserta : ");
        input.nextLine();
        String inputforcek = input.nextLine();

        for (int i = 0; i < alllomba.size(); i++) {
            if (alllomba.get(i).getidtim().contains(inputforcek)) {
                isidata(i);
                /*
                 * } else if (alllomba.get(i).getnamapeserta(i).contains(inputforcek)) {
                 * isidata(i);
                 * } else if (alllomba.get(i).getidpesera(i).contains(inputforcek)) {
                 * isidata(i);
                 * }
                 */
            }
        }

    }

    public void isidata(int index) {
        if (alllomba.get(index).getidlomba().contains("UI")) {
            System.out.println("\n\tBeri Nilai rentang 1-100");
            System.out.print("\n\tNilai Skenariopenggunaan\t: ");
            int skenariopenggunaan = input.nextInt();
            System.out.print("\n\tNilai Latar Belakang\t: ");
            int latarbelakang = input.nextInt();
            System.out.print("\n\tNilai konsistensi\t: ");
            int konsistensi = input.nextInt();
            System.out.print("\n\tNilai Desain\t: ");
            int desain = input.nextInt();
            System.out.print("\n\tNilai User Interface\t: ");
            int userinterface = input.nextInt();

            alllomba.get(index).setnilaisp(skenariopenggunaan);
            alllomba.get(index).setlatarbelakang(latarbelakang);
            alllomba.get(index).setkonsistensi(konsistensi);
            alllomba.get(index).setdesain(desain);
            alllomba.get(index).setui(userinterface);

            System.out.print("\n===\tNilai Berhasil diinput===");

        }
        if (alllomba.get(index).getidlomba().contains("AG")) {
            System.out.println("\n\tBeri Nilai rentang 1-100");
            System.out.print("\n\tNilai Ketepatan Hasil\t: ");
            int ketepatanhasil = input.nextInt();
            System.out.print("\n\tNilai Nilai Eksekusi\t: ");
            int eksekusi = input.nextInt();
            System.out.print("\n\tNilai Pemanfaatan Resource\t: ");
            int pr = input.nextInt();

            alllomba.get(index).setnilaiketepatanhasil(ketepatanhasil);
            alllomba.get(index).setnilaieksekusi(eksekusi);
            alllomba.get(index).setnilaipemanfaatanresource(pr);
        }
    }

    /*
     * public Boolean c ekcontains(String inputforcek){
     * Boo lean c e k= f a lse;
     * for(in t i=0;i<alllomba.size();i++){
     * if(alll o mba.get(i).getidlomba().contains(inputforcek)){
     * cek=true;
     * return cek;
     * }
     * }
     * for(int i=0;i<alllomba.size();i++){
     * 
     * }
     * return cek;
     * }
     */
    // belum slesai
    public void Jadwaljuri() {
        if (!alllomba.isEmpty()) {
            System.out.println("\n\t==============Jadwal Juri============");
            System.out.println("\n\tId Juri\t\tNama Juri\tTanggal Kerja\t\t\tID Lomba\tID TIM\tnamapeserta1");
            for (int i = 0; i < alllomba.size(); i++) {
                alllomba.get(i).viewdatajuri();
                alllomba.get(i).getnamapeserta(i);
                System.out.print("\n");
            }
        } else {
            System.out.println("Belum ada yang daftar");
        }
    }

    public void maketim() {
        System.out.print("\n\tNama peserta 1\t: ");
        input.nextLine();
        String namapeserta1 = input.nextLine();
        if (!namapeserta1.equals(cekpesertada(namapeserta1))) {
            // System.out.println("cek peserta1 : " + cekpesertada(namapeserta1));
            System.out.print("\tID peserta 1\t: ");
            String idpeserta1 = input.nextLine();
            System.out.print("\tNama peserta 2\t: ");
            String namapeserta2 = input.nextLine();
            if (!namapeserta2.equals(cekpesertada(namapeserta2))) {
                // System.out.println("cek peserta2 : " + cekpesertada(namapeserta2));
                System.out.print("\tID peserta 2\t: ");
                String idpeserta2 = input.nextLine();
                System.out.print("\tNama peserta 3\t: ");
                String namapeserta3 = input.nextLine();
                if (!namapeserta3.equals(cekpesertada(namapeserta3))) {
                    // System.out.println("cek peserta3 : " + cekpesertada(namapeserta3));
                    System.out.print("\tID peserta 3\t: ");
                    String idpeserta3 = input.nextLine();
                    System.out.print("\tNama TIM \t: ");
                    String namatim = input.nextLine();
                    // System.out.println(!namatim.equals(cektim(namatim)));
                    // System.out.println("tim :" + cektim(namatim));
                    if (!namatim.equals(cektim(namatim))) {
                        System.out.println("\n\t---------------------------------------------------");
                        System.out.println("\n\tJenis Kategori Lomba \t: ");
                        System.out.println("\t1. UI/UX ");
                        System.out.println("\t2. Algoritma ");
                        System.out.println("\t3. Data Processing ");
                        System.out.print("\n\tInput number : ");
                        int fill = input.nextInt();

                        if (fill == 1) {
                            idforuiux = "UI";
                            if (alllomba.isEmpty()) {
                                urutuiux = 1;
                            } else {
                                urutuiux = +1;
                            }
                            idurut = idmaker(idforuiux, urutuiux); // iduiux,idtim
                            int nilaiskenario = 0;
                            int latarbelakang = 0;
                            int konsistensi = 0;
                            int desain = 0;
                            int userinterface = 0;
                            tglkerja = "17/04/20";
                            Idjuri = "54689789";
                            namajuri = "Aisyah";

                            System.out.println("sebelum add new uiux masuk");
                            alllomba.add(new uiux(idurut, nilaiskenario, latarbelakang,
                                    konsistensi, desain, userinterface, idlomba, starttgl, endtgl,
                                    idurut, tglkerja, namajuri, Idjuri,
                                    namatim, null, null, idpeserta1, namapeserta1,
                                    idpeserta2, namapeserta2, idpeserta3, namapeserta3));
                            System.out.println("setelah add new uiux masuk");
                            peserta peserta1 = new peserta(idurut, idpeserta1, namapeserta1);
                            peserta peserta2 = new peserta(idurut, idpeserta2, namapeserta2);
                            peserta peserta3 = new peserta(idurut, idpeserta3, namapeserta3);
                            System.out.println("setelah add peserta uiux masuk");
                            fillpesertatim(idurut, peserta1, peserta2, peserta3);
                            System.out.println("fill peserta tim masuk");
                            System.out.println("size Alllomba : " + alllomba.size());
                            System.out.println("Size participants : " + getsizeparticipants());
                            System.out.println("\t=========>Tim berhasil dibuat<===========");

                        } else if (fill == 2) {
                            idforalgo = "AG";
                            if (alllomba.isEmpty()) {
                                urutalgoritma = 1;
                            } else {
                                urutalgoritma = +1;
                            }
                            idurut = idmaker(idforalgo, urutalgoritma);// idalgo,idtim
                            nilaiketepatanhasil = 0;
                            nilaieksekusi = 0;
                            nilaipemanfaatanresource = 0;
                            tglkerja = "19/04/20";
                            Idjuri = "46579123";
                            namajuri = "Zhu Sha";
                            alllomba.add(new allgoritma(idurut, nilaiketepatanhasil, nilaieksekusi,
                                    nilaipemanfaatanresource, idlomba, starttgl, endtgl,
                                    idurut, tglkerja, namajuri, Idjuri,
                                    namatim,
                                    null, null, idpeserta1, namapeserta1,
                                    idpeserta2, namapeserta2, idpeserta3, namapeserta3));
                            peserta peserta1 = new peserta(idurut, idpeserta1, namapeserta1);
                            peserta peserta2 = new peserta(idurut, idpeserta2, namapeserta2);
                            peserta peserta3 = new peserta(idurut, idpeserta3, namapeserta3);
                            fillpesertatim(idurut, peserta1, peserta2, peserta3);

                        } else if (fill == 3) {
                            idfordatpros = "DP";
                            if (alllomba.isEmpty()) {
                                urutdatpros = 1;
                            } else {
                                urutdatpros = +1;
                            }
                            idurut = idmaker(idfordatpros, urutdatpros);// idalgo,idtim
                            nilaiketepatanhasil = 0;
                            nilaiwaktueksekusi = 0;
                            nilaipemanfaatanresource = 0;
                            tglkerja = "18/04/20";
                            Idjuri = "79369582";
                            namajuri = "Jessica";
                            alllomba.add(new datpros(idurut, nilaiketepatanhasil, nilaiwaktueksekusi,
                                    nilaipemanfaatanresource, idlomba, starttgl, endtgl, idurut,
                                    tglkerja, namajuri, Idjuri,
                                    namatim, null, null, idpeserta1, namapeserta1,
                                    idpeserta2, namapeserta2, idpeserta3, namapeserta3));
                            peserta peserta1 = new peserta(idurut, idpeserta1, namapeserta1);
                            peserta peserta2 = new peserta(idurut, idpeserta2, namapeserta2);
                            peserta peserta3 = new peserta(idurut, idpeserta3, namapeserta3);
                            fillpesertatim(idurut, peserta1, peserta2, peserta3);
                        }
                    } else {

                        System.out.println("Nama tim ini sudah terdaftar, mohon ganti nama tim");
                    }
                } else {
                    System.out.println("Nama ini sudah terdaftar, max per orang 1 lomba");
                }
            } else {
                System.out.println("Nama ini sudah terdaftar, max per orang 1 lomba");
            }
        } else {
            System.out.println("Nama ini sudah terdaftar, max per orang 1 lomba");
        }

    }

    public void fillpesertatim(String idtim, peserta addpeserta1, peserta addpeserta2, peserta addpeserta3) {
        for (int i = 0; i < alllomba.size(); i++) {
            if (alllomba.get(i).getidtim().equals(idtim)) {
                alllomba.get(i).addpeserta(addpeserta1);
                alllomba.get(i).addpeserta(addpeserta2);
                alllomba.get(i).addpeserta(addpeserta3);
            }
        }
    }

    public Date parsetodate(String tgl) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(tgl);
            FORVOID = date;
        } catch (ParseException e) {
        }
        return (FORVOID);
    }

    public String cekpesertada(String namapeserta) {
        String ketemu = "none";
        for (int i = 0; i < alllomba.size(); i++) {
            for (int j = i; j < alllomba.size(); j++) {
                if (namapeserta.equals(alllomba.get(i).cekpeserta(namapeserta))) {
                    ketemu = namapeserta;
                }
            }
        }
        return (ketemu);
    }

    public String idmaker(String jenis, int urut) {
        String stringurut = Integer.toString(urut);
        String finalid;
        if (stringurut.length() == 1) {
            finalid = jenis + "00" + stringurut;
        } else if (stringurut.length() == 2) {
            finalid = jenis + "0" + stringurut;
        } else {
            finalid = jenis + stringurut;
        }
        return finalid;
    }

    public String cektim(String namatim) {
        String ketemu = "none";
        for (int i = 0; i < alllomba.size(); i++) {

            if (namatim.equals(alllomba.get(i).getnamatim())) {
                ketemu = namatim;
            }

        }

        return ketemu;
    }
}

class lomba extends tim {
    private String idlomba;
    private Date tanggalstart;
    private Date tanggalend;
    private Date tanggalkerja;
    private String namajuri;
    private String idjuri;
    private Date FORLOOP;

    public lomba(String idlomba, Date tanggalstart, Date tanggalend,
            String idtim, String tanggalkerja, String namajuri,
            String idjuri, String namatim,
            String idpeserta, String namapeserta, String idpeserta1,
            String namapeserta1, String idpeserta2,
            String namapeserta2,
            String idpeserta3, String namapeserta3) {
        super(idtim, namatim, idpeserta, namapeserta, idpeserta1, namapeserta1, idpeserta2, namapeserta2, idpeserta3,
                namapeserta3);
        this.idlomba = idlomba;
        this.tanggalstart = tanggalstart;
        this.tanggalend = tanggalend;
        FORLOOP = (parsetodate(tanggalkerja));
        this.tanggalkerja = FORLOOP;

    }

    public void setnamapeserta() {
        super.setnamapeserta();
    }

    public String getidlomba() {
        return idlomba;
    }

    public Date parsetodate(String tgl) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(tgl);
            FORLOOP = date;
        } catch (ParseException e) {
        }
        return (FORLOOP);
    }

    public void setidjuri(String idjuri) {
        this.idjuri = idjuri;
    }

    // method uiux
    public void setnilaisp(int nilaiskenariopenggunaan) {
    }

    public void setlatarbelakang(int nilailatarbelakang) {
    }

    public void setkonsistensi(int nilaikonsistensi) {
    }

    public void setui(int nilaiui) {
    }

    public void setdesain(int desain) {
    }

    // method datpros
    public void setnilaiketepatanhasil(int nilaiketepatanhasil) {
    }

    public void setnilaiwaktueksekusi(int nilaiwaktueksekusi) {
    }

    public void setnilaipemanfaatanresource(int nilaipemanfaatanresource) {
    }

    // method algoritma
    public void setnilaieksekusi(int nilaieksekusi) {
    }

    public Date gettanggalstart() {
        return tanggalstart;
    }

    public Date gettanggalend() {
        return tanggalend;
    }

    public void setnamajuri(String namajuri) {
        this.namajuri = namajuri;
    }

    public void settglkerja(String tglkerja) {
        FORLOOP = parsetodate(tglkerja);
        this.tanggalkerja = FORLOOP;
    }

    public Date gettanggalkerja() {
        return tanggalkerja;
    }

    public void viewnilai() {
        super.viewnilai();
    }

    public String getidjuri() {
        return idjuri;
    }

    public String getnamajuri() {
        return namajuri;
    }

    public void settglstart(Date Tglstart) {
        this.tanggalstart = Tglstart;
    }

    public void settglend(Date tglend) {
        this.tanggalend = tglend;
    }

    public void viewlomba() {
    }

    public int getsizeparticipants() {
        return (super.getsizeparticipants());
    }

    public void viewdatajuri() {
        System.out.print("\t" + getidjuri() + "\t" + getnamajuri() + "\t\t"
                + gettanggalkerja() + "\t" + getidlomba() + "\t\t" + getidtim());
    }

    public void viewtim() {
    }

}

class uiux extends lomba {
    private String iduiux;
    private int nilaiuiux;
    private int skenariopenggunaan;
    private int latarbelakang;
    private int konsistensi;
    private int desain;
    private int userinterface;

    public uiux(String iduiux, int skenariopenggunaan,
            int latarbelakang, int konsistensi, int desain, int userinterface,
            String idlomba, Date tanggalstart, Date tanggalend,
            String idtim, String tanggalkerja, String namajuri,
            String idjuri, String namatim,
            String isinull, String isiinull, String idpeserta1,
            String namapeserta1, String idpeserta2,
            String namapeserta2,
            String idpeserta3, String namapeserta3) {
        super(idlomba, tanggalstart, tanggalend, idtim, tanggalkerja,
                namajuri, idjuri, namatim, isinull, isiinull, idpeserta1,
                namapeserta1, idpeserta2, namapeserta2, idpeserta3, namapeserta3);
        this.iduiux = iduiux;
        this.skenariopenggunaan = skenariopenggunaan;
        this.latarbelakang = latarbelakang;
        this.konsistensi = konsistensi;
        this.userinterface = userinterface;
        this.desain = desain;
        this.nilaiuiux = (this.skenariopenggunaan + this.latarbelakang +
                this.konsistensi + this.userinterface + this.desain) / 5;
        setidjuri(idjuri);
        setnamajuri(namajuri);
        settglkerja(tanggalkerja);

    }

    public String getiduiux() {
        return (iduiux);
    }

    public int getnilaiuiux() {
        return (nilaiuiux);
    }

    public void setidjuri(String idjuri) {
        super.setidjuri(idjuri);
    }

    public void setnamajuri(String namajuri) {
        super.setnamajuri(namajuri);
    }

    public void settglkerja(String tglkerja) {
        super.settglkerja(tglkerja);
    }

    public void setnilaisp(int nilaiskenariopenggunaan) {
        super.setnilaisp(nilaiskenariopenggunaan);
        this.skenariopenggunaan = nilaiskenariopenggunaan;
        this.nilaiuiux = (this.skenariopenggunaan + this.latarbelakang +
                this.konsistensi + this.userinterface + this.desain) / 5;

    }

    public void setlatarbelakang(int nilailatarbelakang) {
        super.setlatarbelakang(nilailatarbelakang);
        this.latarbelakang = nilailatarbelakang;
        this.nilaiuiux = (this.skenariopenggunaan + this.latarbelakang +
                this.konsistensi + this.userinterface + this.desain) / 5;
    }

    public void setkonsistensi(int nilaikonsistensi) {
        super.setkonsistensi(nilaikonsistensi);
        this.konsistensi = nilaikonsistensi;
        this.nilaiuiux = (this.skenariopenggunaan + this.latarbelakang +
                this.konsistensi + this.userinterface + this.desain) / 5;
    }

    public void setui(int nilaiui) {
        super.setui(nilaiui);
        this.userinterface = nilaiui;
        this.nilaiuiux = (this.skenariopenggunaan + this.latarbelakang +
                this.konsistensi + this.userinterface + this.desain) / 5;
    }

    public void setdesain(int desain) {
        super.setdesain(desain);
        this.desain = desain;
        this.nilaiuiux = (this.skenariopenggunaan + this.latarbelakang +
                this.konsistensi + this.userinterface + this.desain) / 5;
    }

    public void viewdatajuri() {
        super.viewdatajuri();
    }

    public void viewnilai() {
        super.viewnilai();
        System.out.print("\t\t" + getnilaiuiux());
    }
}

class datpros extends lomba {
    // datpros=data processing
    private String iddatpros;
    private int avedatpros;
    private int nilaiketepatanhasil;
    private int nilaiwaktueksekusi;
    private int nilaipemanfaatanresource;

    public datpros(String iddatpros, int nilaiketepatanhasil,
            int nilaiwaktueksekusi, int nilaipemanfaatanresource,
            String idlomba, Date tanggalstart, Date tanggalend,
            String idtim, String tanggalkerja, String namajuri,
            String idjuri, String namatim,
            String isinull, String isiinull, String idpeserta1,
            String namapeserta1, String idpeserta2,
            String namapeserta2,
            String idpeserta3, String namapeserta3) {
        super(idlomba, tanggalstart, tanggalend, idtim, tanggalkerja,
                namajuri, idjuri, namatim, isinull, isiinull, idpeserta1,
                namapeserta1, idpeserta2, namapeserta2, idpeserta3, namapeserta3);
        this.iddatpros = iddatpros;
        this.nilaiketepatanhasil = nilaiketepatanhasil;
        this.nilaiwaktueksekusi = nilaiwaktueksekusi;
        this.nilaipemanfaatanresource = nilaipemanfaatanresource;
        this.avedatpros = (this.nilaiketepatanhasil + this.nilaiwaktueksekusi
                + this.nilaipemanfaatanresource) / 3;
        setidjuri(idjuri);
        setnamajuri(namajuri);
        settglkerja(tanggalkerja);
    }

    public int getavedatpros() {
        return avedatpros;
    }

    public void setnilaiketepatanhasil(int nilaiketepatanhasil) {
        super.setnilaiketepatanhasil(nilaiketepatanhasil);
        this.nilaiketepatanhasil = nilaiketepatanhasil;
        this.avedatpros = (this.nilaiketepatanhasil + this.nilaiwaktueksekusi
                + this.nilaipemanfaatanresource) / 3;
    }

    public void setnilaiwaktueksekusi(int nilaiwaktueksekusi) {
        super.setnilaiwaktueksekusi(0);
        this.nilaiwaktueksekusi = nilaiwaktueksekusi;
        this.avedatpros = (this.nilaiketepatanhasil + this.nilaiwaktueksekusi
                + this.nilaipemanfaatanresource) / 3;
    }

    public void setnilaipemanfaatanresource(int nilaipemanfaatanresource) {
        super.setnilaipemanfaatanresource(nilaipemanfaatanresource);
        this.nilaipemanfaatanresource = nilaipemanfaatanresource;
        this.avedatpros = (this.nilaiketepatanhasil + this.nilaiwaktueksekusi
                + this.nilaipemanfaatanresource) / 3;
    }

    public void setidjuri(String idjuri) {
        super.setidjuri(idjuri);
    }

    public void setnamajuri(String namajuri) {
        super.setnamajuri(namajuri);
    }

    public void settglkerja(String tglkerja) {
        super.settglkerja(tglkerja);
    }

    public void viewdatajuri() {
        super.viewdatajuri();
    }

    public void viewnilai() {
        super.viewnilai();
        System.out.print("\t" + getavedatpros());
    }
}

class allgoritma extends lomba {
    private String idalgo;
    private int avealgo;
    private int nilaiketepatanhasil;
    private int nilaieksekusi;
    private int nilaipemanfaatanresource;

    public allgoritma(String idalgo, int nilaiketepatanhasil,
            int nilaieksekusi, int nilaipemanfaatanresource,
            String idlomba, Date tanggalstart, Date tanggalend,
            String idtim, String tanggalkerja, String namajuri,
            String idjuri, String namatim,
            String isinull, String isiinull, String idpeserta1,
            String namapeserta1, String idpeserta2,
            String namapeserta2,
            String idpeserta3, String namapeserta3) {
        super(idlomba, tanggalstart, tanggalend, idtim, tanggalkerja,
                namajuri, idjuri, namatim, isinull, isiinull, idpeserta1,
                namapeserta1, idpeserta2, namapeserta2, idpeserta3, namapeserta3);
        this.idalgo = idalgo;
        this.nilaiketepatanhasil = nilaiketepatanhasil;
        this.nilaieksekusi = nilaieksekusi;
        this.nilaipemanfaatanresource = nilaipemanfaatanresource;
        this.avealgo = (this.nilaiketepatanhasil + this.nilaieksekusi + this.nilaipemanfaatanresource) / 3;
    }

    public int getnilaiavealgo() {
        return avealgo;
    }

    public String getidalgo() {
        return idalgo;
    }

    public void setnilaiketepatanhasil(int nilaiketepatanhasil) {
        super.setnilaiketepatanhasil(nilaiketepatanhasil);
        this.nilaiketepatanhasil = nilaiketepatanhasil;
        this.avealgo = (this.nilaiketepatanhasil + this.nilaieksekusi + this.nilaipemanfaatanresource) / 3;
    }

    public void setnilaipemanfaatanresource(int pemanfaatanresourse) {
        super.setnilaipemanfaatanresource(pemanfaatanresourse);
        this.nilaipemanfaatanresource = pemanfaatanresourse;
    }

    public void setnilaieksekusi(int nilaieksekusi) {
        super.setnilaieksekusi(nilaieksekusi);
        this.nilaieksekusi = nilaieksekusi;
        this.avealgo = (this.nilaiketepatanhasil + this.nilaieksekusi + this.nilaipemanfaatanresource) / 3;
    }

    public void setidjuri(String idjuri) {
        super.setidjuri(idjuri);
    }

    public void setnamajuri(String namajuri) {
        super.setnamajuri(namajuri);
    }

    public void settglkerja(String tglkerja) {
        super.settglkerja(tglkerja);
    }

    public void viewdatajuri() {
        super.viewdatajuri();
    }

    public void viewnilai() {
        super.viewnilai();
        System.out.print("\t" + getnilaiavealgo());
    }

}

class juri extends jadwaljuri {
    private String namajuri;
    private String idjuri;

    public juri(String idlomba, Date tanggalstart, Date tanggalend,
            String idtim, String tanggalkerja, String namajuri,
            String idjuri, String namatim,
            String idpeserta, String namapeserta, String idpeserta1,
            String namapeserta1, String idpeserta2,
            String namapeserta2,
            String idpeserta3, String namapeserta3) {
        super(idlomba, tanggalstart, tanggalend, idtim, tanggalkerja,
                namajuri, idjuri, namatim, idpeserta, namapeserta, idpeserta1,
                namapeserta1, idpeserta2, namapeserta2, idpeserta3, namapeserta3);
        this.namajuri = namajuri;
        this.idjuri = idjuri;
    }

    public String getnamajuri() {
        return (namajuri);
    }

    public String getidjuri() {
        return (idjuri);
    }

    public void viewdatajuri() {
        System.out.print("\t" + getidjuri() + "\t" + getnamajuri());
        super.viewdatajuri();
    }

}

class jadwaljuri extends lomba {
    private Date tanggalkerja;
    public Date FORJJ;

    public jadwaljuri(String idlomba, Date tanggalstart, Date tanggalend,
            String idtim, String tanggalkerja, String namajuri, String idjuri, String namatim,
            String idpeserta, String namapeserta, String idpeserta1,
            String namapeserta1, String idpeserta2,
            String namapeserta2,
            String idpeserta3, String namapeserta3) {
        super(idlomba, tanggalstart, tanggalend, idtim, tanggalkerja,
                namajuri, idjuri, namatim, idpeserta, namapeserta, idpeserta1,
                namapeserta1, idpeserta2, namapeserta2, idpeserta3, namapeserta3);
        FORJJ = parsetodate(tanggalkerja);
        this.tanggalkerja = FORJJ;
    }

    public Date parsetodate(String tgl) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(tgl);
            FORJJ = date;
        } catch (ParseException e) {
        }
        return (FORJJ);
    }

    public String getnamajuri() {
        return (getnamajuri());
    }

    public Date gettanggalkerja() {
        return tanggalkerja;
    }

    public void settanggalkerja(Date tanggalkerja) {
        this.tanggalkerja = tanggalkerja;
    }

    public void viewdatajuri() {
        System.out.print("\t" + gettanggalkerja());
        super.viewdatajuri();
    }
}

class peserta {
    private String idpeserta;
    private String namapeserta;
    private String idtim;

    public peserta(String idtim, String idpeserta, String namapeserta) {
        this.idpeserta = idpeserta;
        this.namapeserta = namapeserta;
    }

    public String getidpeserta() {
        return idpeserta;
    }

    public String getnamapeserta() {
        return namapeserta;
    }

    public void setnamapeserta() {
        this.namapeserta = namapeserta;
    }

    public void viewpeserta() {
        System.out.println("\t" + getidpeserta() + "\t" + getnamapeserta());
    }
}

class tim extends peserta {
    private String idtim;
    private String namatim;
    private ArrayList<peserta> participants;

    public tim(String idtim, String namatim,
            String idpeserta, String namapeserta,
            String idpeserta1, String namapeserta1, String idpeserta2,
            String namapeserta2,
            String idpeserta3, String namapeserta3) {
        super(idtim, idpeserta, namapeserta);
        this.idtim = idtim;
        this.namatim = namatim;
        // peserta p1 = new peserta(idtim, idpeserta1, namapeserta1);
        // peserta p2 = new peserta(idtim, idpeserta2, namapeserta2);
        // peserta p3 = new peserta(idtim, idpeserta3, namapeserta3);
        // addpeserta(p1);
        // addpeserta(p2);
        // addpeserta(p3);
        participants = new ArrayList<>();

    }

    public String getnamapeserta(int index) {
        return (participants.get(index).getnamapeserta());
        // return (super.getnamapeserta());
    }

    public String getidpesera(int index) {
        return (participants.get(index).getidpeserta());
    }

    public void addpeserta(peserta peserta) {
        participants.add(peserta);
    }

    public String cekpeserta(String namapeserta) {
        String ketemu = "none";
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).getnamapeserta().equals(namapeserta)) {
                ketemu = namapeserta;
            }

        }
        return ketemu;
    }

    public int getsizeparticipants() {
        return (participants.size());
    }

    public String ambilnamapeserta(int index) {
        return (participants.get(index).getnamapeserta());
    }

    public void setnamatim(String nama) {
        this.namatim = nama;
    }

    public String getidtim() {
        return idtim;
    }

    public String getnamatim() {
        return namatim;
    }

    public void viewnilai() {
        System.out.print("\t" + getidtim()
                + "\t\t" + getnamatim());
    }

    public void viewpeserta() {
    }
}
