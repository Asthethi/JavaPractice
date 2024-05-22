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
    checkstyle_jar = 'utils/checkstyle-10.16.0-all.jar'  # Use the consistent JAR file name
    config_file = 'utils/AndroidStyle_new.xml'

    for java_file in java_files:
        with open(java_file, 'r') as file:
            code = file.read()
            #subprocess.run(["pylint", java_file])
            #print(java_file)

    cmd = ['java','-jar', checkstyle_jar, '-c', config_file] + java_files
    result = subprocess.run(cmd,capture_output=True, text=True)

    if result.returncode == 0:
        print("Checkstyle passed with no violations.")
        print(result.stderr)
    else:
        print("Checkstyle violations found:")
        print(result)
        # Analyze code for naming conventions
        #check_naming_conventions(code)


if __name__ == "__main__":
    main()
