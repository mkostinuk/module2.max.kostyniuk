package org.example.settings;

@Deprecated /* soon - reading from file  */
public class Info {

    public enum OrgainsmEnum {
        BEAR, BOA, EAGLE, FOX, WOLF, BOAR, BUFFALO, BUG, DEER, DUCK, GOAT, HORSE, MOUSE, RABBIT, SHEEP, PLANT
    }
    /*  Predators  */


    /*Bear*/

    public static final OrgainsmEnum bearType = OrgainsmEnum.BEAR;
    public static final String bearUC = "\uD83D\uDC3B";
    public static final int bearWeight = 500;
    public static final int bearMaxCount = 5;
    public static final int bearSpeed = 2;
    public static final int bearFoodKilo = 80;

    /*Boa*/
    public static final OrgainsmEnum boaType = OrgainsmEnum.BOA;
    public static final String boaUC = "\uD83D\uDC0D";
    public static final int boaWeight = 15;
    public static final int boaMaxCount = 30;
    public static final int boaSpeed = 1;
    public static final int boaFoodKilo = 3;

    /*Eagle*/
    public static final OrgainsmEnum eagleType = OrgainsmEnum.EAGLE;
    public static final String eagleUC = "\uD83E\uDD85";
    public static final int eagleWeight = 6;
    public static final int eagleMaxCount = 20;
    public static final int eagleSpeed = 3;
    public static final int eagleFoodKilo = 1;

    /*Fox*/
    public static final OrgainsmEnum foxType = OrgainsmEnum.FOX;
    public static final String foxUC = "\uD83E\uDD8A";
    public static final int foxWeight = 8;
    public static final int foxMaxCount = 30;
    public static final int foxSpeed = 2;
    public static final int foxFoodKilo = 2;

    /*Wolf*/
    public OrgainsmEnum wolfType = OrgainsmEnum.WOLF;
    public static final String wolfUc = "\uD83D\uDC3A";
    public static final int wolfWeight = 50;
    public static final int wolfMaxCount = 30;
    public static final int wolfSpeed = 3;
    public static final int wolfFoodKilo = 8;

    /*  Herbivorous  */


    /*Boar*/
    public static final OrgainsmEnum boarType = OrgainsmEnum.BOAR;
    public static final String boarUC = "\uD83D\uDC17";
    public static final int boarWeight = 400;
    public static final int boarMaxCount = 50;
    public static final int boarSpeed = 2;
    public static final int BoarFoodKilo = 50;

    /*Buffalo*/
    public static final OrgainsmEnum buffaloType = OrgainsmEnum.BUFFALO;
    public static final String buffaloUc = "\uD83D\uDC03";
    public static final int buffaloWeight = 700;
    public static final int buffaloMaxCount = 10;
    public static final int buffaloSpeed = 3;
    public static final int buffaloFoodKilo = 100;

    /*Bug*/
    public static final OrgainsmEnum bugType = OrgainsmEnum.BUG;
    public static final String bugUC = "\uD83D\uDC1B";
    public static final double bugWeight = 0.01;
    public static final int bugMaxCount = 1000;
    public static final int bugMaxSpeed = 0;
    public static final int bugFoodKilo = 0;

    /*Deer*/
    public static final OrgainsmEnum deerType = OrgainsmEnum.DEER;
    public static final String deerUc = "\uD83E\uDD8C";
    public static final int deerWeight = 300;
    public static final int deerMaxCount = 20;
    public static final int deerSpeed = 4;
    public static final int deerFoodKilo = 50;

    /*Duck*/
    public static final OrgainsmEnum duckType = OrgainsmEnum.DUCK;
    public static final String duckUc = "\uD83E\uDD86";
    public static final int duckWeight = 1;
    public static final int duckMaxCount = 200;
    public static final int duckSpeed = 4;
    public static final double duckFoodKilo = 0.15;


    /*Goat*/
    public static final OrgainsmEnum goatType = OrgainsmEnum.GOAT;
    public static final String goatUc = "\uD83D\uDC10";
    public static final int goatWeight = 60;
    public static final int goatMaxCount = 140;
    public static final int goatSpeed = 3;
    public static final int goatFoodKilo = 10;

    /*Horse*/
    public static final OrgainsmEnum horseType = OrgainsmEnum.HORSE;
    public static final String horseUc = "\uD83D\uDC0E";
    public static final int horseWeight = 400;
    public static final int gorseMaxCount = 20;
    public static final int horseSpeed = 4;
    public static final int gorseFoodKilo = 60;

    /*Mouse*/
    public static final OrgainsmEnum mouseType = OrgainsmEnum.MOUSE;
    public static final String mouseUC = "\uD83D\uDC2D";
    public static final double mouseWeight = 0.05;
    public static final int mouseMaxCount = 500;
    public static final int mouseSpeed = 1;
    public static final double mouseFoodKilo = 0.01;

    /*Rabbit*/
    public static final OrgainsmEnum rabbitType = OrgainsmEnum.RABBIT;
    public static final String rabbitUC = "\uD83D\uDC07";
    public static final int rabbitWeight = 2;
    public static final int rabbitMaxCount = 150;
    public static final int rabbitSpeed = 2;
    public static final double rabbitFoodKilo = 0.45;

    /*Sheep*/
    public static final OrgainsmEnum sheepType = OrgainsmEnum.SHEEP;
    public static final String sheepUC = "\uD83D\uDC11";
    public static final int sheepWeight = 70;
    public static final int sheepMaxCount = 140;
    public static final int sheepSpeed = 3;
    public static final int sheepFoodKilo = 15;

    /* Plants */
    public static final OrgainsmEnum plantType = OrgainsmEnum.PLANT;
    public static final String plantUc = "\uD83C\uDF3F";
    public static final int plantWeight = 1;
    public static final int plantMaxCount = 200;

}
