import java.io.FileWriter;
import java.io.IOException;

public class CalculateSalary {
    public void WriteFile(String[] personelList, String[] monitoringList) throws IOException {

        for (String lines : personelList) {
            String[] line = lines.split("\t");
            switch (line[2]) {
                case "FACULTY_MEMBER":            //calculate the faculty member salary
                    FacultyMember facultyMember = new FacultyMember();
                    String fileName = line[1];
                    fileName = fileName + ".txt";
                    FileWriter fileWriter = new FileWriter(fileName);
                    String[] name = line[0].split("\\s");
                    fileWriter.write("Name : " + name[0] + "\n" + "Surname : " + name[1] + "\n" + "Registiration Number : "
                            + line[1] + "\n" + "Position : FACULTY_MEMBER" + "\n" + "Year of Start : " + line[3] + "\n");
                    String yearOfStart = line[3];
                    int year = Integer.parseInt(yearOfStart.trim());
                    facultyMember.severancePay = (2020 - year) * 20 * 0.8;
                    int count = 0;
                    for (String row : monitoringList) {
                        String[] month = row.split("\t");
                        if (month[0].equals(line[1])) {
                            month[0] = "0";
                            for (String week : month) {
                                String hourOfWork = week;
                                int hour = Integer.parseInt(hourOfWork.trim());
                                if (hour > 48) {
                                    facultyMember.addCourseFee = 160;
                                } else if (hour > 40) {
                                    facultyMember.addCourseFee = (hour - 40) * 20;
                                }
                                count += facultyMember.addCourseFee;
                            }
                        }
                    }
                    double totalSalary = facultyMember.baseSalary + facultyMember.ssBenefits +
                            facultyMember.severancePay + count;
                    fileWriter.write("Total Salary : " + totalSalary + " TL");
                    fileWriter.close();
                    break;
                case ("RESEARCHASSISTANT"):           //calculate the researchAssistant salary
                    ResearchAssistant researchAssistant = new ResearchAssistant();
                    String fileName2 = line[1];
                    fileName = fileName2 + ".txt";
                    FileWriter fileWriter2 = new FileWriter(fileName);
                    String[] name2 = line[0].split("\\s");
                    fileWriter2.write("Name : " + name2[0] + "\n" + "Surname : " + name2[1] + "\n" + "Registiration Number : "
                            + line[1] + "\n" + "Position : RESEARCHASSISTANT" + "\n" + "Year of Start : " + line[3] + "\n");
                    String yearOfStart2 = line[3];
                    int year2 = Integer.parseInt(yearOfStart2.trim());
                    researchAssistant.severancePay = (2020 - year2) * 20 * 0.8;
                    double totalSalary2 = researchAssistant.baseSalary + researchAssistant.ssBenefits + researchAssistant.severancePay;
                    fileWriter2.write("Total Salary : " + totalSalary2 + " TL");
                    fileWriter2.close();
                    break;
                case ("WORKER")://calculate the worker salary
                    Worker worker = new Worker();
                    String fileName3 = line[1];
                    fileName = fileName3 + ".txt";
                    FileWriter fileWriter3 = new FileWriter(fileName);
                    String[] name3 = line[0].split("\\s");
                    fileWriter3.write("Name : " + name3[0] + "\n" + "Surname : " + name3[1] + "\n" + "Registiration Number : "
                            + line[1] + "\n" + "Position : WORKER" + "\n" + "Year of Start : " + line[3] + "\n");
                    String yearOfStart3 = line[3];
                    int year3 = Integer.parseInt(yearOfStart3.trim());
                    worker.severancePay = (2020 - year3) * 20 * 0.8;
                    int count3 = 0;
                    for (String row : monitoringList) {
                        String[] month = row.split("\t");
                        if (month[0].equals(line[1])) {
                            month[0] = "0";
                            for (String week : month) {
                                String hourOfWork = week;
                                int hour = Integer.parseInt(hourOfWork.trim());
                                if (hour > 50) {
                                    worker.overWorkSalary = 110;
                                } else if (hour > 39) {
                                    worker.overWorkSalary = (hour - 40) * 11;
                                }
                                count3 += worker.overWorkSalary;
                            }
                        }
                    }
                    double totalSalary3 = count3 + worker.dayOfWork * 4 + worker.severancePay;
                    fileWriter3.write("Total Salary : " + totalSalary3 + " TL");
                    fileWriter3.close();
                    break;
                case ("SECURITY"):               //calculate the security salary
                    Security security = new Security();
                    String fileName4 = line[1];
                    fileName = fileName4 + ".txt";
                    FileWriter fileWriter4 = new FileWriter(fileName);
                    String[] name4 = line[0].split("\\s");
                    fileWriter4.write("Name : " + name4[0] + "\n" + "Surname : " + name4[1] + "\n" + "Registiration Number : "
                            + line[1] + "\n" + "Position : SECURITY" + "\n" + "Year of Start : " + line[3] + "\n");
                    String yearOfStart4 = line[3];
                    int year4 = Integer.parseInt(yearOfStart4.trim());
                    security.severancePay = (2020 - year4) * 20 * 0.8;
                    int count4 = 0;
                    for (String row : monitoringList) {
                        String[] month = row.split("\t");
                        if (month[0].equals(line[1])) {
                            month[0] = "0";
                            for (String week : month) {
                                String hourOfWork = week;
                                int hour = Integer.parseInt(hourOfWork.trim());
                                if (hour < 54) {
                                    security.hourOfWork = 10 * hour;
                                } else {
                                    security.hourOfWork = 10 * 54;
                                }
                                count4 += security.hourOfWork;
                            }
                        }
                    }
                    double totalSalary4 = count4 + security.foodMoney + security.transMoney + +security.severancePay;
                    fileWriter4.write("Total Salary : " + totalSalary4 + " TL");
                    fileWriter4.close();
                    break;
                case ("OFFICER"):            //calculate the officer salary
                    Officer officer = new Officer();
                    String fileName5 = line[1];
                    fileName5 = fileName5 + ".txt";
                    FileWriter fileWriter5 = new FileWriter(fileName5);
                    String[] name5 = line[0].split("\\s");
                    fileWriter5.write("Name : " + name5[0] + "\n" + "Surname : " + name5[1] + "\n" + "Registiration Number : "
                            + line[1] + "\n" + "Position : OFFICER" + "\n" + "Year of Start : " + line[3] + "\n");
                    String yearOfStart5 = line[3];
                    int year5 = Integer.parseInt(yearOfStart5.trim());
                    officer.severancePay = (2020 - year5) * 20 * 0.8;
                    int count5 = 0;
                    for (String row : monitoringList) {
                        String[] month = row.split("\t");
                        if (month[0].equals(line[1])) {
                            month[0] = "0";
                            for (String week : month) {
                                String hourOfWork = week;
                                int hour = Integer.parseInt(hourOfWork.trim());
                                if (hour > 50) {
                                    officer.overWorkSalary = 10 * 20;
                                } else if (hour > 40) {
                                    officer.overWorkSalary = (hour - 40) * 20;
                                }
                                count5 += officer.overWorkSalary;
                            }
                        }
                    }
                    double totalSalary5 = officer.baseSalary + officer.ssBenefits + officer.severancePay + count5;
                    fileWriter5.write("Total Salary : " + totalSalary5 + " TL");
                    fileWriter5.close();
                    break;
                case ("CHIEF"):              //calculate the chief salary
                    Chief chief = new Chief();
                    String fileName6 = line[1];
                    fileName = fileName6 + ".txt";
                    FileWriter fileWriter6 = new FileWriter(fileName);
                    String[] name6 = line[0].split("\\s");
                    fileWriter6.write("Name : " + name6[0] + "\n" + "Surname : " + name6[1] + "\n" + "Registiration Number : "
                            + line[1] + "\n" + "Position : CHIEF" + "\n" + "Year of Start : " + line[3] + "\n");
                    String yearOfStart6 = line[3];
                    int year6 = Integer.parseInt(yearOfStart6.trim());
                    chief.severancePay = (2020 - year6) * 20 * 0.8;
                    int count6 = 0;
                    for (String row : monitoringList) {
                        String[] month = row.split("\t");
                        if (month[0].equals(line[1])) {
                            month[0] = "0";
                            for (String week : month) {
                                String hourOfWork = week;
                                int hour = Integer.parseInt(hourOfWork.trim());
                                if (hour > 48) {
                                    chief.overWorkSalary = 15 * 8;
                                } else if (hour > 39) {
                                    chief.overWorkSalary = (hour - 40) * 15;
                                }
                                count6 += chief.overWorkSalary;
                            }
                        }
                    }
                    double totalSalary6 = count6 + chief.dayOfWork * 4 + chief.severancePay;
                    fileWriter6.write("Total Salary : " + totalSalary6 + " TL");
                    fileWriter6.close();
                    break;
                case ("PARTTIME_EMPLOYEE"):          //calculate the parttime employee salary
                    PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
                    String fileName7 = line[1];
                    fileName7 = fileName7 + ".txt";
                    FileWriter fileWriter7 = new FileWriter(fileName7);
                    String[] name7 = line[0].split("\\s");
                    fileWriter7.write("Name : " + name7[0] + "\n" + "Surname : " + name7[1] + "\n" + "Registiration Number : "
                            + line[1] + "\n" + "Position : PARTTIME_EMPLOYEE" + "\n" + "Year of Start : " + line[3] + "\n");
                    String yearOfStart7 = line[3];
                    int year7 = Integer.parseInt(yearOfStart7.trim());
                    partTimeEmployee.severancePay = (2020 - year7) * 20 * 0.8;
                    int count7 = 0;
                    for (String row : monitoringList) {
                        String[] month = row.split("\t");
                        if (month[0].equals(line[1])) {
                            month[0] = "0";
                            for (String week : month) {
                                String hourOfWork = week;
                                int hour = Integer.parseInt(hourOfWork.trim());
                                if (hour > 9) {
                                    partTimeEmployee.hourOfWork = hour * 18;
                                } else if (hour > 20) {
                                    partTimeEmployee.hourOfWork = 20 * 18;
                                } else {
                                    partTimeEmployee.hourOfWork = 0;
                                }
                                count7 += partTimeEmployee.hourOfWork;
                            }
                        }
                    }
                    double totalSalary7 = partTimeEmployee.severancePay + count7;
                    fileWriter7.write("Total Salary : " + totalSalary7 + " TL");
                    fileWriter7.close();
                    break;
            }
        }
    }
}
