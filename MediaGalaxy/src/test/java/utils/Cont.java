package utils;

public class Cont {

    private String prenume;
    private String nume;
    private String telefon;
    private String email;
    private String parola;
    private String confirmParola;

    public Cont(ContBuilder builder) {
        this.nume = builder.nume;
        this.prenume = builder.prenume;
        this.telefon = builder.telefon;
        this.email = builder.email;
        this.parola = builder.parola;
        this.confirmParola = builder.confirmParola;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }

    public String getConfirmParola() {
        return confirmParola;
    }

    public static class ContBuilder {
        private String nume;
        private String prenume;
        private String telefon;
        private String email;
        private String parola;
        private String confirmParola;

        public ContBuilder withNume(String nume) {
            this.nume = nume;
            return this;
        }

        public ContBuilder withPrenume(String prenume) {
            this.prenume = prenume;
            return this;
        }

        public ContBuilder withTelefon(String telefon) {
            this.telefon = telefon;
            return this;
        }

        public ContBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ContBuilder withParola(String parola) {
            this.parola = parola;
            return this;
        }

        public ContBuilder withConfirmParola(String confirmParola) {
            this.confirmParola = confirmParola;
            return this;
        }

        public Cont build() {
            return new Cont(this);
        }
    }

    @Override
    public String toString() {
        return "Cont [nume=" + nume + ", prenume=" + prenume + ", telefon=" + telefon + ", email=" + email + ", parola=" + parola + ", confirmParola="
                + confirmParola + "]";
    }

}
