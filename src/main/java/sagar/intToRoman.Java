class IntToRoman {
    public String intToRomanShort(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] numerals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<values.length;i++) {
            while(num>=values[i]){
                num=num-values[i];
                sb.append(numerals[i]);
            }
        }
        return sb.toString();
    }
    
    public String intToRomanLong(int num) {
        StringBuilder sb = new StringBuilder("");
        int count=0;
        count = num/1000;
        while(count>0) {
            sb.append("M");
            count--;
        }
        num = num%1000;
        if(num>=900) {
            sb.append("CM");
        } else if (num>=500) {
             sb.append("D");
            count = (num-500)/100;
            while(count>0) {
                sb.append("C");
                count--;
            }
        } else if(num<500 && num>=400) {
            sb.append("CD");
        } else if(num>=100) {
            count = num/100;
            while(count>0) {
                sb.append("C");
                count--;
            }
        }
        num = num%100;
        if(num>=90) {
            sb.append("XC");
        } else if(num>=50) {
            sb.append("L");
            count = (num-50)/10;
            while(count>0) {
                sb.append("X");
                count--;
            }
        } else if(num<50 && num>=40) {
            sb.append("XL");
        } else if(num>=10) {
            count  = num/10;
            while(count>0) {
                sb.append("X");
                count--;
            }
        }
        num = num%10;
        if(num>=9) {
            sb.append("IX");
        } else if(num>=5) {
            sb.append("V");
            count = (num-5);
            while(count>0) {
                sb.append("I");
                count--;
            }
        } else if(num==4) {
            sb.append("IV");
        } else if(num>=0 && num<4) {
            count = num;
            while(count>0) {
                sb.append("I");
                count--;
            }
        }
        return sb.toString();
    }
}
