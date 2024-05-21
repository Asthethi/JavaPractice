import re
import os
import sys
import subprocess

def check_naming_conventions(code):
    errors = []

    print(code)

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

    for java_file in java_files:
        with open(java_file, 'r') as file:
            code = file.read()
            subprocess.run(["pylint", java_file])
            print(java_file)

        # Analyze code for naming conventions
        #check_naming_conventions(code)


if __name__ == "__main__":
    main()
