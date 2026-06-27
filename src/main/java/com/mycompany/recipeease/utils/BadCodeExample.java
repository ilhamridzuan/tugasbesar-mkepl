package com.mycompany.recipeease.utils;

public class BadCodeExample {
    // 1. Pelanggaran Keamanan (Security Hotspot): Hardcoded password/credential
    private static final String DB_PASSWORD = "AdminSecurePassword123!"; 

    public void processData(String input) {
        // 2. Bug Kritis: Potensi NullPointerException yang sangat jelas
        String upperInput = null;
        if (input.equals("test")) { // Akan crash (NPE) jika parameter 'input' bernilai null
            upperInput = input.toUpperCase();
        }
        // Bug Kritis: Akan crash (NPE) jika parameter 'input' bukan "test"
        System.out.println("Length: " + upperInput.length()); 

        // 3. Code Smell Parah: Empty Catch Block (menyembunyikan error tanpa log)
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Dibiarkan kosong. SonarCloud melarang keras menyembunyikan error seperti ini.
        }
    }

    // 4. Duplikasi Kode (Copy-Paste)
    public void printWarningOne() {
        System.out.println("Ini adalah pesan peringatan duplikat");
        System.out.println("SonarCloud mendeteksi baris ini berulang-ulang");
        System.out.println("Duplikasi kode menurunkan nilai maintainability");
    }

    public void printWarningTwo() {
        System.out.println("Ini adalah pesan peringatan duplikat");
        System.out.println("SonarCloud mendeteksi baris ini berulang-ulang");
        System.out.println("Duplikasi kode menurunkan nilai maintainability");
    }
}
