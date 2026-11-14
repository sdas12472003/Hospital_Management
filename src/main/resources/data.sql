INSERT INTO public.patient
    (name, date_of_birth, gender, email, created_at, blood_group)
VALUES
    ('Aarav Sharma', '1990-05-10', 'MALE',
     'aarav.sharma@example.com', CURRENT_DATE, 'O_POSITIVE'),

    ('Diya Patel', '1995-08-20', 'FEMALE',
     'diya.patel@example.com', CURRENT_DATE, 'A_POSITIVE'),

    ('Rishabh Verma', '1988-03-15', 'MALE',
     'rishabh.verma@example.com', CURRENT_DATE, 'B_POSITIVE'),

    ('Neha Iyer', '1992-12-01', 'FEMALE',
     'neha.iyer@example.com', CURRENT_DATE, 'AB_POSITIVE'),

    ('Kabir Singh', '1993-07-11', 'MALE',
     'kabir.singh@example.com', CURRENT_DATE, 'O_NEGATIVE')

ON CONFLICT DO NOTHING;

INSERT INTO public.doctor
    (name, specialization, emeil)
VALUES
    ('Dr. Amit Sharma', 'Cardiologist',
     'amit.sharma@hospital.com'),

    ('Dr. Priya Singh', 'Neurologist',
     'priya.singh@hospital.com'),

    ('Dr. Rahul Verma', 'Orthopedic Surgeon',
     'rahul.verma@hospital.com'),

    ('Dr. Sneha Das', 'Dermatologist',
     'sneha.das@hospital.com'),

    ('Dr. Arjun Roy', 'Pediatrician',
     'arjun.roy@hospital.com'),

    ('Dr. Neha Gupta', 'Gynecologist',
     'neha.gupta@hospital.com'),

    ('Dr. Suman Ghosh', 'General Physician',
     'suman.ghosh@hospital.com'),

    ('Dr. Ananya Bose', 'Ophthalmologist',
     'ananya.bose@hospital.com'),

    ('Dr. Vikash Kumar', 'ENT Specialist',
     'vikash.kumar@hospital.com'),

    ('Dr. Riya Patel', 'Psychiatrist',
     'riya.patel@hospital.com')

ON CONFLICT DO NOTHING;