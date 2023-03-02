public class Match { //müsabaka
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    int select;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight, int select){
        this.f1 = f1;
        this.f2 = f2;
        this. minWeight = minWeight;
        this.maxWeight = maxWeight;
        if(select > 0 && select < 3){
            this.select = select;
        }else{
            this.select = 0;
        }
    }
    boolean isSelect(){
        double randomSelect = Math.random() * 3;
        return randomSelect <= this.select;
    }

    boolean isCheck(){
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) &&
                (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin(){
        if(this.f1.health == 0){
            System.out.println(this.f2.name + " Kazandı.");
            return true;
        }
        if(this.f2.health == 0){
            System.out.println(this.f1.name + " Kazandı.");
            return true;
        }
        return false;
    }



    void run(){
        if(isCheck()){
            while(this.f1.health > 0 && this.f2.health > 0){
                System.out.println("======New Round======");

                if(isSelect()){
                    this.f2.health = this.f1.hit(this.f2);
                    System.out.println(this.f2.name + " kalan canı " + this.f2.health);
                    if(isWin()){
                        break;
                    }
                }else{
                    this.f1.health = this.f2.hit(this.f1);
                    System.out.println(this.f1.name + " kalan canı " + this.f1.health);
                    if(isWin()){
                        break;
                    }
                }

            }
        }else{
            System.out.println("Dövüşçülerin sikletleri uymuyor !");
        }
    }
}
