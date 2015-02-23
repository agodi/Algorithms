import sys
import pickle

class Paciente:
    
    def __init__(self, cedula, nombre, telefono, edad):
        self.cedula = cedula
        self.nombre = nombre
        self.telefono = telefono
        self.edad = edad

    def get_cedula(self):
        return self.cedula
    
    def get_nombre(self):
        return self.nombre

    def get_telefono(self):
        return self.telefono

    def get_edad(self):
        return self.edad

    def __str__(self):
        return "cedula: " + self.cedula + \
               " nombre: " + self.nombre + \
               " telefono: " + self.telefono + \
               " edad: " + str(self.edad)

class Enfermedad:
    
    def __init__(self, nombre, sintomas, tratamientos):
        self.nombre = nombre
        self.sintomas = sintomas
        self.tratamientos = tratamientos

    def get_nombre(self):
        return self.nombre

    def get_sintomas(self):
        return self.sintomas

    def get_tratamientos(self):
        return self.tratamientos

    def __str__(self):
        return "Nombre: " + self.nombre + " sintomas: " + self.sintomas + " tratamientos: " + tratamientos

class Expediente:
    
    def __init__(self, paciente, enfermedades):
        self.paciente = paciente
        self.enfermedades = enfermedades

    def get_paciente(self):
        return self.paciente

    def get_enfermedades(self):
        return self.enfermedades

    def imprimir(self):
        paciente = expediente.get_paciente()
        print("*"*11+"Expediente"+"*"*11)
        print("Nombre:", paciente.get_nombre())
        print("Edad:",paciente.get_edad(),"\tTelefono:",paciente.get_telefono())
        print("*"*10+"Enfermedades"+"*"*10)
        for enfermedad in expediente.get_enfermedades():
            print("Nombre      :",enfermdad.get_nombre())
            print("Sintomas    :",enfermdad.get_sintomas())
            print("Tratamientos:",enfermdad.get_tratamientos())
            print("*"*11)
        print("-"*32)

    def __str__(self):
        return "Paciente: " + str(self.paciente) + " enfermedades: " + self.enfermedades


expediente = None
opcion = None
opciones = ["1", "2", "3", "4", "5", "S"]

def start():
    while not opcion or opcion != "S":
        menu()
        if opcion == "1":
            crear_expediente()
        elif opcion == "2":
            cargar_expediente()
        elif opcion == "3":
            modificar_expediente()
        elif opcion == "4":
            salvar_expediente()
        elif opcion == "5":
            imprimir_expediente()
        elif opcion == "S":
            sys.exit()
    
def crear_expediente():
    global expediente
    cedula = ""
    nombre = ""
    telefono = ""
    edad = 0
    while not cedula:
        cedula = input("Introduce la cedula del paciente:\n").strip()
    while not nombre:
        nombre = input("Introduce el nombre del paciente:\n").strip()
    telefono = input("Introduce el telefono del paciente:\n")
    edad = input("Introduce la edad del paciente:\n")
    expediente = Expediente(Paciente(cedula, nombre, telefono, edad), [])

def cargar_expediente():
    global expediente
    try:
        with open(input("Introduce el numero del expediente: ") + ".dat", "rb") as f:
            expediente = pickle.load(f)
            expediente.imprimir()
    except IOError:
        print("No se puede abrir el archivo:", filename)
        start()

def salvar_expediente():
    if expediente:
        filename = expediente.get_paciente().get_cedula() + ".dat"
        try:
            with open(filename, "wb+") as f:
                pickle.dump(expediente, f)
        except IOError:
            print("No se puede salvar el archivo:", filename)
            start()            

def imprimir_expediente():
    if expediente:
        expediente.imprimir()
    else:
        print("No hay un expediente seleccionado para imprimir")
        start()
        
def menu():
    global opcion
    while True:
        opcion = input("\n\
           Selecciona una opción\n\
           1. Crear Expediente\n\
           2. Cargar Expediente\n\
           3. Modificar Expediente\n\
           4. Salvar Expediente\n\
           5. Imprimir Expediente\n\
           S. Salir\n").upper()
        if any(x == opcion for x in opciones):
            break
        else:
            print("Opcion no valida. Intentalo nuevamente")

start()
