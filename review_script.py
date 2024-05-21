import re
import os
import sys

def check_naming_conventions(code):
    errors = []

    # Check variable and function names for snake_case
    # snake_case_pattern = re.compile(r'^[a-z][a-z0-9_]*$')
    # for match in re.finditer(r'\b[a-zA-Z][a-zA-Z0-9_]*\b', code):
    #     name = match.group()
    #     if not snake_case_pattern.match(name) and not name.isupper():
    #         errors.append(f"Variable or function '{name}' does not follow snake_case convention")

    # Check class names for CamelCase
    camel_case_pattern = re.compile(r'^[a-zA-Z]+([A-Z][a-z]+)+$')
    for match in re.finditer(r'\b[A-Z][a-zA-Z0-9]*\b', code):
        name = match.group()
        if not camel_case_pattern.match(name):
            errors.append(f"Class '{name}' does not follow CamelCase convention")

    return errors

def find_java_files(directory):
    java_files = []
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith('.java'):
                java_files.append(os.path.join(root, file))
    return java_files

def main():
    # Find all Java files in the repository
    java_files = find_java_files('.')

    all_errors = []
    for java_file in java_files:
        with open(java_file, 'r') as file:
            code = file.read()

        # Analyze code for naming conventions
        errors = check_naming_conventions(code)
        if errors:
            all_errors.append(f"Errors in file {java_file}:")
            all_errors.extend(errors)
    
    if all_errors:
        print("Naming convention violations found:")
        for error in all_errors:
            print(error)
        sys.exit(1)
    else:
        print("No naming convention violations found")

if __name__ == "__main__":
    main()
