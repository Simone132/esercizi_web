class Giocatore
    {
        private String nome;
        private int tentativi;
        public Giocatore()
        {
            this.nome="";
            this.tentativi =0;
        }
        public String getNome()
        {
            return nome;
        }
        public int getTentativi()
        {
            return tentativi;
        }
        public void setNome(String nome)
        {
            this.nome= nome;
        }
        public void setTentativi(int tentativi)
        {
            this.tentativi= tentativi;
        }
    }
