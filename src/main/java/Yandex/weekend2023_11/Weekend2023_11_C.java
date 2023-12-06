package Yandex.weekend2023_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
Опытная команда
Каждому тимлиду важно следить за опытностью своей команды. А именно выделять самого опытного члена своей команды и понимать, как его опытность соотносится с опытностью остальных членов его команды

Команда - это живой организм, ее состав постоянно изменяется. Иногда к ней присоединяются новые инженеры, порой кто-то уходит. Бывает, что кто-то возвращается в команду после ухода и даже проделывает это несколько раз!

Дан список пар <имя, момент времени>, упорядоченный по неубыванию времени и описывающий события, происходящие с командой. Изначально состав команды пустой. Если на текущий момент в команде не содержится инженера с таким именем, то событие означает, что он в заданный момент времени присоединяется к команде. Иначе, что он наоборот уходит из команды

Опытность - это суммарное количество времени, которое конкретный инженер провел в команде. Более формально, опытность - это сумма разностей между текущим моментом (или моментом ухода) и соответствующим ему моментом присоединения к команде по всем периодам работы инженера в команде.

После обработки каждого события требуется определить самого опытного члена команда и то, насколько суммарная опытность оставшейся части команды (то есть всех, кроме самого опытного) больше опытности самого опытного члена команды
 */

public class Weekend2023_11_C {

    static Map<String, Empl> teamMap = new HashMap<>();
    static Deque<Empl> maxEmpl = new ArrayDeque<>();
    static Empl bestEmpl;
    static int currTime = 1;
    static int totalExp = 0;
    static int totalEmpls = 0;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        int events = Integer.parseInt(br.readLine());

        for (int i = 0; i < events; i++) {
            String[] s = br.readLine().split(" ");
            int eventTime = Integer.parseInt(s[1]);
            processEmpl(s[0], eventTime);

            currTime = eventTime;
        }


        br.close();
        pw.close();
    }

    public static void processEmpl(String name, int eventTime) {
        totalExp += totalEmpls * (eventTime - currTime);
        if (teamMap.get(name) == null) {
            Empl newEmpl = new Empl(name, eventTime);
            teamMap.put(name, newEmpl);

            if (bestEmpl == null) {
                bestEmpl = newEmpl;
            } else {
                if (bestEmpl.getFullExp(eventTime) <= newEmpl.getFullExp(eventTime)) {
                    if (bestEmpl.getFullExp(eventTime) == newEmpl.getFullExp(eventTime)) {
                        if(newEmpl.emplName.compareTo(bestEmpl.emplName) < 0){
                            maxEmpl.push(bestEmpl);
                            bestEmpl = newEmpl;
                        }
                    }
                }
            }

            totalEmpls++;
        }else{
            Empl oldEmpl = teamMap.get(name);
            if(!oldEmpl.retired){
                oldEmpl.retired = true;
                if(bestEmpl == oldEmpl){
                    if(maxEmpl.isEmpty()){
                        for(Map.Entry<String, Empl> ee: teamMap.entrySet()){
                            if(!ee.getValue().retired){
                                bestEmpl = ee.getValue();
                                break;
                            }
                        }
                    }else{
                        Empl poppedEmp = maxEmpl.pop();
                        while(!poppedEmp.retired && !maxEmpl.isEmpty()){
                            poppedEmp = maxEmpl.pop();
                        }
                        if(maxEmpl.isEmpty()){
                            for(Map.Entry<String, Empl> ee: teamMap.entrySet()){
                                if(!ee.getValue().retired){
                                    poppedEmp = ee.getValue();
                                    break;
                                }
                            }
                        }
                        bestEmpl = poppedEmp;
                    }
                }
                totalExp -= oldEmpl.getFullExp(eventTime);
                oldEmpl.totalExp = oldEmpl.getFullExp(eventTime);
                totalEmpls--;
            }else{
                //снова примем
                oldEmpl.retired = false;
                oldEmpl.startTime = eventTime;
                if (bestEmpl.getFullExp(eventTime) <= oldEmpl.getFullExp(eventTime)) {
                    if (bestEmpl.getFullExp(eventTime) == oldEmpl.getFullExp(eventTime)) {
                        if(oldEmpl.emplName.compareTo(bestEmpl.emplName) < 0){
                            maxEmpl.push(bestEmpl);
                            bestEmpl = oldEmpl;
                        }
                    }else{
                        maxEmpl.push(bestEmpl);
                        bestEmpl = oldEmpl;
                    }
                }
                totalExp += oldEmpl.getFullExp(eventTime);
                totalEmpls++;
            }
        }
        pw.println(bestEmpl.emplName + " " + (totalExp - (2 * bestEmpl.getFullExp(eventTime))));
    }
}

class Empl {
    public String emplName;
    public int startTime;
    public int totalExp;
    public boolean retired = false;

    public Empl(String emplName, int startTime) {
        this.emplName = emplName;
        this.startTime = startTime;
    }

    public int getFullExp(int currTime) {
        return this.totalExp + (currTime - startTime);
    }

}