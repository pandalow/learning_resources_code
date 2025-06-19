import json
import mysql.connector

# Reading JSON file
with open('program.json', 'r') as file:
   program_data = json.load(file)

# Connect to MySQL Database
db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="03279891zxj",
    database="mockhunter"
)
cursor = db.cursor()

# Insert queries
program_query = """
    INSERT INTO program (name, degree, code, duration, collegeID)
    VALUES (%s, %s, %s, %s, %s)
"""

college_query = """
    INSERT INTO college (name, IID)
    VALUES (%s, %s)
"""

program_course_query = """
    INSERT INTO program_course (PID, CID, optional, program_course_semester, year)
    VALUES (%s, %s, %s, %s, %s)
"""

for program in program_data:
    # Parse the college name
    college_name = program.get('college', '') or 'null'
    IID = 1
    # Generate college tuple value
    college_value = (
        college_name,
        IID
    )

    cursor.execute("SELECT collegeID FROM college WHERE name = %s", (college_name,))
    college_record = cursor.fetchone()

    if college_record:
        college_id = college_record[0]
    else:
        # Execute college insert query
        cursor.execute(college_query, college_value)
        college_id = cursor.lastrowid

    # Generate program tuple value
    degree = program.get('degree', '') or 'null'
    program_name = program.get('name', '')
    program_code = program.get('CAOCode', '') or 'null'
    duration = program.get('duration', '') or 'null'

    program_value = (
        program_name,
        degree,
        program_code,
        duration,
        college_id
    )
    cursor.execute(program_query, program_value)
    program_id = cursor.lastrowid

    for courses in program.get('courses', []):
        optional = courses.get('optional', '') or 'null'
        program_course_semester = courses.get('semester', '') or 'null'
        year = courses.get('year', '') or 'null'

        # Query the CID
        course_code = courses.get('code', '')
        cursor.execute("SELECT CID FROM course WHERE code = %s", (course_code,))
        course_record = cursor.fetchone()

        if course_record:
            course_id = course_record[0]
            courses_value = (
                program_id,
                course_id,
                optional,
                program_course_semester,
                year
            )
            cursor.execute("SELECT * FROM program_course WHERE PID = %s AND CID = %s", (program_id, course_id))
            program_course_record = cursor.fetchone()
            if not program_course_record:
                cursor.execute(program_course_query, courses_value)
                print(f"Inserted into program_course: PID = {program_id}, CID = {course_id}")
        else:
            print(f"Course with code {course_code} not found in the database.")

# Submit the transaction
db.commit()

print("Data inserted successfully.")

# Close Database connection
cursor.close()
db.close()
