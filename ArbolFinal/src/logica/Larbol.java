package logica;

import bean.Barbol;
import bean.Nodos;

public class Larbol extends Barbol {

    public Larbol(String cadena) {
        char[] datos = cadena.toCharArray();
        for (int i = 0; i < datos.length; i++) {
            Insertar(datos[i], getPunta());
        }
    }

    public void RecorrerInorden(Nodos R) {
        if (R != null) {
            RecorrerInorden(R.getLi());
            Mostrar(R.getDato());
            RecorrerInorden(R.getLd());
        }
    }

    public void Mostrar(char a) {
        System.out.print(a);
    }

    public void RecorrerPosorden(Nodos R) {
        if (R != null) {
            RecorrerPosorden(R.getLi());
            RecorrerPosorden(R.getLd());
            Mostrar(R.getDato());
        }
    }

    public void RecorrerPreorden(Nodos R) {
        if (R != null) {
            Mostrar(R.getDato());
            RecorrerPreorden(R.getLi());
            RecorrerPreorden(R.getLd());
        }
    }

    public void Insertar(char dato, Nodos P) {
        if (getPunta() == null) {
            setPunta(new Nodos(dato));
        } else {
            if (dato > P.getDato()) {
                if (P.getLd() == null) {
                    P.setLd(new Nodos(dato));
                    FactorBalance(getPunta(), dato, true);
                } else {
                    Insertar(dato, P.getLd());
                }
            } else if (dato < P.getDato()) {
                if (P.getLi() == null) {
                    P.setLi(new Nodos(dato));
                    FactorBalance(getPunta(), dato, true);
                } else {
                    Insertar(dato, P.getLi());
                }
            }
        }
    }

    public void Mostrar1hijos(Nodos R) {
        if (R != null) {
            Mostrar1hijos(R.getLi());
            if ((R.getLd() == null && R.getLi() != null) || (R.getLd() != null && R.getLi() == null)) {
                Mostrar(R.getDato());
            }
            Mostrar1hijos(R.getLd());
        }
    }

    public void MostrarPadres(Nodos R, char dato, String cadena) {
        if (R != null) {
            if (R.getDato() > dato) {
                cadena += R.getDato();
                MostrarPadres(R.getLi(), dato, cadena);
            } else if (R.getDato() < dato) {
                cadena += R.getDato();
                MostrarPadres(R.getLd(), dato, cadena);
            } else {
                StringBuilder stringbuilder = new StringBuilder(cadena);
                String invertida = stringbuilder.reverse().toString();
                System.out.println(invertida);
            }
        }
    }

    public void MostrarHojas(Nodos R) {
        if (R != null) {
            MostrarHojas(R.getLi());
            if (R.getLd() == null & R.getLi() == null) {
                Mostrar(R.getDato());
            }
            MostrarHojas(R.getLd());
        }
    }

    public void MostrarLi(Nodos R) {
        if (R != null) {
            MostrarLi(R.getLi());
            if (R.getLd() == null & R.getLi() != null) {
                Mostrar(R.getDato());
            }
            MostrarLi(R.getLd());
        }
    }

    public boolean MostrarHermanoDerecho(Nodos R, char dato, boolean bandera) {
        if (R != null) {
            if (R.getLi() != null & R.getLd() != null) {
                if (R.getLi().getDato() == dato) {
                    System.out.print("El dato tiene un hermano derecho, el cual es: ");
                    Mostrar(R.getLd().getDato());
                    System.out.println();
                    bandera = true;
                }
            }
            if (!bandera & R.getDato() > dato) {
                bandera = MostrarHermanoDerecho(R.getLi(), dato, bandera);
            } else if (R.getDato() < dato) {
                bandera = MostrarHermanoDerecho(R.getLd(), dato, bandera);
            }
        }
        return bandera;
    }

    public boolean MostrarHermanoIzquierdo(Nodos R, char dato, boolean bandera) {
        if (R != null) {
            if (R.getLi() != null & R.getLd() != null) {
                if (R.getLd().getDato() == dato) {
                    System.out.print("El dato tiene un hermano izquierdo, el cual es: ");
                    Mostrar(R.getLi().getDato());
                    System.out.println();
                    bandera = true;
                }
            }
            if (!bandera & R.getDato() > dato) {
                bandera = MostrarHermanoIzquierdo(R.getLi(), dato, bandera);
            } else if (R.getDato() < dato) {
                bandera = MostrarHermanoIzquierdo(R.getLd(), dato, bandera);
            }
        }

        return bandera;
    }

    public void HermanoDelDato(Nodos R, char dato, boolean bandera) {
        if (MostrarHermanoDerecho(R, dato, false)) {
        } else if (MostrarHermanoIzquierdo(R, dato, false)) {
        } else {
            System.out.println("El dato no tiene hermanos");
        }
    }

    public int ContarHojas(Nodos R, int cont) {
        if (R != null) {
            cont = ContarHojas(R.getLi(), cont);
            cont = ContarHojas(R.getLd(), cont);
            if (R.getLd() == null & R.getLi() == null) {
                cont++;
            }
        }
        return cont;
    }

    public int ContarPadres(Nodos R, int cont) {
        if (R != null) {
            cont = ContarPadres(R.getLi(), cont);
            cont = ContarPadres(R.getLd(), cont);
            if (R.getLd() != null | R.getLi() != null) {
                cont++;
            }
        }
        return cont;
    }

    public void Altura(char dato) {
        Nodos R = Buscardato(getPunta(), dato);
        System.out.println("La altura de " + dato + " es: " + CalcularAltura(R, 0));
    }

    public int CalcularAltura(Nodos R, int cont) {
        if (R != null) {
            int cont2 = 0;
            int cont3 = 0;
            if (R.getLi() != null) {
                cont2 = CalcularAltura(R.getLi(), cont + 1);
            }
            if (R.getLd() != null) {
                cont3 = CalcularAltura(R.getLd(), cont + 1);
            }
            if (R.getLi() != null || R.getLd() != null) {
                if (cont2 > cont3) {
                    cont = cont2;
                } else {
                    cont = cont3;
                }
            }
        }
        return cont;
    }

    public Nodos Buscardato(Nodos R, char dato) {
        if (R != null) {
            if (R.getDato() > dato) {
                R = Buscardato(R.getLi(), dato);
            } else if (R.getDato() < dato) {
                R = Buscardato(R.getLd(), dato);
            } else {
                return R;
            }
        }
        return R;
    }

    public void Ancestros(Nodos R, char dato) {
        if (R != null) {
            if (R.getDato() > dato) {
                Ancestros(R.getLi(), dato);
                System.out.print(R.getDato());
            } else if (R.getDato() < dato) {
                Ancestros(R.getLd(), dato);
                System.out.print(R.getDato());
            }
        }
    }

    public void NivelDato(Nodos R, char dato, int cont) {
        if (R != null) {
            if (R.getDato() > dato) {
                NivelDato(R.getLi(), dato, cont + 1);
            } else if (R.getDato() < dato) {
                NivelDato(R.getLd(), dato, cont + 1);
            } else {
                System.out.println("El nivel del dato es: " + cont);
            }
        }
    }

    public int CalcularPrimos(Nodos R, char dato, int cont) {
        if (R != null) {
            if (cont == 0) {
                if (R.getDato() > dato) {
                    cont = CalcularPrimos(R.getLi(), dato, cont);
                } else if (R.getDato() < dato) {
                    cont = CalcularPrimos(R.getLd(), dato, cont);
                } else {
                    return 1;
                }
            }
            if (cont == 1) {
                return 2;
            } else if (cont == 2) {
                if (R.getDato() > dato) {
                    if (R.getLd() != null) {
                        cont = CalcularPrimos(R.getLd(), dato, cont + 1);
                    } else {
                        return 5;
                    }
                } else if (R.getDato() < dato) {
                    if (R.getLi() != null) {
                        cont = CalcularPrimos(R.getLi(), dato, cont + 1);
                    } else {
                        return 5;
                    }
                }
            }
            if (cont == 3) {
                cont++;
                if (R.getLi() == null && R.getLd() == null) {
                    return 5;
                } else {
                    if (R.getLd() != null) {
                        System.out.print(R.getLd().getDato());
                    }
                    if (R.getLi() != null) {
                        System.out.print(R.getLi().getDato());
                    }
                }
            }
        }
        return cont;
    }

    public void Primos(char dato) {
        int cont = CalcularPrimos(getPunta(), dato, 0);
        if (cont != 4) {
            System.out.println("El dato no tiene primos");
        }
        System.out.println();
    }

    public void MostratArbol() {
        int Aarbol = CalcularAltura(getPunta(), 0);
        String[][] arbolM = new String[Aarbol + 1][((int) Math.pow(2, Aarbol + 1)) - 1];
        for (int i = 0; i < arbolM.length; i++) {
            for (int j = 0; j < arbolM[0].length; j++) {
                arbolM[i][j] = " ";
            }
        }
        Matrizarbol(arbolM, getPunta(), Aarbol + 1, 0, 0, 0, Aarbol);
        for (int i = 0; i < arbolM.length; i++) {
            for (int j = 0; j < arbolM[0].length; j++) {
                System.out.print(arbolM[i][j]);
            }
            System.out.println();
        }
    }

    public void Matrizarbol(String[][] M, Nodos R, int Narbol, int cont, int Cp, int fh, int Ap) {
        if (R != null) {
            if (R == getPunta()) {
                Cp = ((int) Math.pow(2, Narbol)) / 2 - 1;
                M[cont][Cp] = R.getDato() + "";
            } else {
                Cp += (int) Math.pow(2, Ap) * fh;
                M[cont][Cp] = R.getDato() + "";
            }
            Matrizarbol(M, R.getLi(), Narbol, cont + 1, Cp, -1, Ap - 1);
            Matrizarbol(M, R.getLd(), Narbol, cont + 1, Cp, 1, Ap - 1);
        }
    }

    public boolean FactorBalance(Nodos R, char dato, boolean Switch) {
        if (R.getDato() > dato) {
            Switch = FactorBalance(R.getLi(), dato, true);
        } else if (R.getDato() < dato) {
            Switch = FactorBalance(R.getLd(), dato, true);
        }
        if (Switch) {
            int Ahi = 0, Ahd = 0;
            if (R.getLi() != null) {
                Ahi = CalcularAltura(R.getLi(), 0) + 1;
            }
            if (R.getLd() != null) {
                Ahd = CalcularAltura(R.getLd(), 0) + 1;
            }
            R.setFb(Ahi - Ahd);
            if (R.getFb() < -1 || R.getFb() > 1) {
                Switch = false;
                AVL(R, Ahi, Ahd);
            }
        }
        return Switch;
    }

    public void AVL(Nodos P, int Ahi, int Ahd) {
        Nodos S = null;
        if (P != getPunta()) {
            S = BuscarPadre(getPunta(), P.getDato());
        }
        Nodos q, R;
        if (Ahi > Ahd) {
            q = P.getLi();
        } else {
            q = P.getLd();
        }
        if (Ahi > Ahd) {
            R = q.getLd();
        } else {
            R = q.getLi();
        }
        if (P.getFb() < 0 && q.getFb() < 0) {
            q.setLi(P);
            P.setLd(R);
            auxAVL(S, P, q);
        } else if (P.getFb() > 0 && q.getFb() > 0) {
            q.setLd(P);
            P.setLi(R);
            auxAVL(S, P, q);

        } else if (P.getFb() < 0 && q.getFb() > 0) {
            q.setLi(R.getLd());
            P.setLd(R.getLi());
            R.setLd(q);
            R.setLi(P);
            auxAVL(S, P, R);

        } else {
            q.setLd(R.getLi());
            P.setLi(R.getLd());
            R.setLi(q);
            R.setLd(P);
            auxAVL(S, P, R);

        }
    }

    public Nodos BuscarPadre(Nodos R, char dato) {
        if (R != null) {
            if (R.getDato() > dato) {
                if (R.getLi().getDato() != dato) {
                    R = BuscarPadre(R.getLi(), dato);
                }
            } else if (R.getDato() < dato) {
                if (R.getLd().getDato() != dato) {
                    R = BuscarPadre(R.getLd(), dato);
                }
            }
        }
        return R;
    }

    public void auxAVL(Nodos S, Nodos P, Nodos q) {
        if (S != null) {
            if (S.getLi() == P) {
                S.setLi(q);
            } else {
                S.setLd(q);
            }
        } else {
            setPunta(q);
        }
    }
}