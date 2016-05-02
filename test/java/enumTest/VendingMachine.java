package enumTest;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

import javax.persistence.criteria.CriteriaBuilder;

import  static  enumTest.Input.*;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public class VendingMachine {
    private static State state=State.RESTING;
    private static int amount=0;
    private  static  Input selection=null;
    enum StateDurtion{ TRANSIENT }
    enum State{
        RESTING{
            void next(Input input){
                switch (Category.categoriza(input)){
                    case MONEY:
                        amount+=input.amount();
                        state=ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state=TERMINAL;
                        break;
                    default:
                }
            }
        },
        ADDING_MONEY{
            void next(Input input){
                switch (Category.categoriza(input)){
                    case MONEY:
                        amount+=input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection=input;
                        if(amount<selection.amount())
                            System.out.println("Insufficient monet for "+selection);
                        else
                            state=DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state= GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state=TERMINAL;
                        break;
                    default:
                }
            }
        },
        DISPENSING(StateDurtion.TRANSIENT){
         void next(){
             System.out.println("here is your"+selection);
             amount-=selection.amount();
             state=GIVING_CHANGE;
         }
        },
        GIVING_CHANGE(StateDurtion.TRANSIENT){
        void next(){
            if(amount>0){
                System.out.println("Your change"+amount);
                amount=0;
            }
            state=RESTING;
            }
        },
        TERMINAL{
        void output(){
            System.out.println("Halted");}
        };
        private boolean isTransient=false;
        State(){}
        State(StateDurtion trans){isTransient=true;}
        void next(Input input){
            throw new RuntimeException("Only call"+
            "next(Input input) for non-transient states");
        }
        void next(){
            throw new RuntimeException("Only call"+
                    "next() for StateDuration.TRANSIENT states");
        }
        void output(){
            System.out.println(amount);}
    }
}
