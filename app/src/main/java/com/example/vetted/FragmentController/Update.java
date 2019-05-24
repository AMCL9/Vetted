package com.example.vetted.FragmentController;

public abstract class Update {


        private String passedTerm;


        public Update(String term){
            this.passedTerm=term;

        }




        @Override
        public String toString() {
            return super.toString();
        }

        public void changeName(String newName) {
            this.passedTerm = newName;
        }

    public String getPassedTerm() {
        return passedTerm;
    }

    public void setPassedTerm(String passedTerm) {
        this.passedTerm = passedTerm;
    }
}

