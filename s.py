import os

def generate_project_structure(directory, structure_file, extensions=None):
    with open(structure_file, 'w', encoding='utf-8') as struct_file:
        for root, dirs, files in os.walk(directory):
            level = root.replace(directory, '').count(os.sep)
            indent = ' ' * 4 * level
            struct_file.write(f'{indent}{os.path.basename(root)}/\n')
            subindent = ' ' * 4 * (level + 1)
            for filename in files:
                if extensions is None or filename.endswith(tuple(extensions)):
                    struct_file.write(f'{subindent}{filename}\n')

def concatenate_files(directory, output_file, extensions=None):
    with open(output_file, 'w', encoding='utf-8') as outfile:
        for root, _, files in os.walk(directory):
            for filename in files:
                if extensions is None or filename.endswith(tuple(extensions)):
                    file_path = os.path.join(root, filename)
                    try:
                        with open(file_path, 'r', encoding='utf-8') as infile:
                            outfile.write(f'\n\n# --- Inicio de {file_path} ---\n\n')
                            outfile.write(infile.read())
                            outfile.write(f'\n\n# --- Fin de {file_path} ---\n\n')
                    except Exception as e:
                        print(f'Error al leer {file_path}: {e}')

if __name__ == '__main__':
    project_directory = './employeeClient'  # Reemplaza con la ruta a tu proyecto
    structure_output_file = 'estructura_proyecto.txt'
    content_output_file = 'contenido_concatenado.txt'
    file_extensions = ['.java', '.xml', '.yml', '.properties']  # Extensiones de archivos a incluir

    generate_project_structure(project_directory, structure_output_file, file_extensions)
    concatenate_files(project_directory, content_output_file, file_extensions)
