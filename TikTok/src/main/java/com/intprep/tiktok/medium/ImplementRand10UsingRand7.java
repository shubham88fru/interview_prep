package com.intprep.tiktok.medium;

class SolBase {
    protected int rand7() {
        return 1;//dummy impl.
    }
}

//@link - https://leetcode.com/problems/implement-rand10-using-rand7/description/
//@check - https://www.youtube.com/watch?v=BvYd6KSW4nQ&t=320s
public class ImplementRand10UsingRand7 extends SolBase {
    public int rand10() {
        // return pass1();
        // return pass2();
        // return pass3();
        return pass4();
    }

    //@check's soln. No clue why it works and others dont.
    private int pass4() {
        int a = rand7();
        int b = rand7();
        while (a > 5) a = rand7();
        while (b == 7) b = rand7();
        return (b <= 3)? a: a+5;
    }

    private int pass3() {
        int a = rand7();
        int b = rand7();

        while (a + b > 11) {
            a = rand7();
            b = rand7();
        }

        return (a + b - 1);
    }

    private int pass2() {
        int a = rand7();
        int b = rand7();
        int c = (a-1)*7 + b;
        return (c%10)+1;
    }

    //doesn't work for large test cases.
    //probably because its not enoughly random.
    private int pass1() {
        return rand7() + (rand7()/2);
    }
}
